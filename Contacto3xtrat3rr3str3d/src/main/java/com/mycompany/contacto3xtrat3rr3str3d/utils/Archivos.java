package com.mycompany.contacto3xtrat3rr3str3d.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class Archivos {

    private static final long TAMANO_MAXIMO = 5L * 1024 * 1024;

    public record Contenido(String texto, Charset codificacion, String finLinea) {
        public Contenido(String texto) {
            this(texto, StandardCharsets.UTF_8, "\n");
        }
    }

    public static Contenido abrir(File archivo) throws IOException {
        if (!archivo.exists()) throw new IOException("el archivo no existe");
        if (!archivo.isFile()) throw new IOException("no es un archivo");
        if (!archivo.canRead()) throw new IOException("no hay permiso de lectura");
        if (archivo.length() > TAMANO_MAXIMO) throw new IOException("el archivo es demasiado grande");
        byte[] bytes = Files.readAllBytes(archivo.toPath());
        for (byte b : bytes) {
            if (b == 0) throw new IOException("no es un archivo de texto");
        }
        Charset codificacion = StandardCharsets.UTF_8;
        String texto;
        try {
            texto = StandardCharsets.UTF_8.newDecoder().decode(ByteBuffer.wrap(bytes)).toString();
        } catch (CharacterCodingException e) {
            codificacion = StandardCharsets.ISO_8859_1;
            texto = new String(bytes, codificacion);
        }
        if (texto.startsWith("\uFEFF")) texto = texto.substring(1);
        String finLinea = texto.contains("\r\n") ? "\r\n" : "\n";
        return new Contenido(texto.replace("\r\n", "\n").replace('\r', '\n'), codificacion, finLinea);
    }

    public static String leer(File archivo) throws IOException {
        return abrir(archivo).texto();
    }

    public static void escribir(File archivo, String contenido) throws IOException {
        guardar(archivo, new Contenido(contenido));
    }
    //temporal para mientras 
    public static void guardar(File archivo, Contenido contenido) throws IOException {
        if (archivo.isDirectory()) throw new IOException("ya existe una carpeta con ese nombre");
        if (archivo.exists() && !archivo.canWrite()) throw new IOException("el archivo es de solo lectura");
        Path destino = archivo.toPath().toAbsolutePath();
        Files.createDirectories(destino.getParent());
        String texto = contenido.texto().replace("\n", contenido.finLinea());
        Path temporal = Files.createTempFile(destino.getParent(), "." + archivo.getName(), ".tmp");
        try {
            Files.write(temporal, texto.getBytes(contenido.codificacion()));
            try {
                Files.move(temporal, destino, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            } catch (IOException e) {
                Files.move(temporal, destino, StandardCopyOption.REPLACE_EXISTING);
            }
        } finally {
            Files.deleteIfExists(temporal);
        }
    }

    public static File conExtension(File archivo, String extension) {
        if (extension == null || archivo.getName().contains(".")) return archivo;
        return new File(archivo.getParentFile(), archivo.getName() + "." + extension);
    }

    public static String extension(File archivo) {
        String nombre = archivo.getName();
        int punto = nombre.lastIndexOf('.');
        return punto < 0 ? null : nombre.substring(punto + 1);
    }

    public static void mover(File origen, File destino) throws IOException {
        Files.move(origen.toPath(), destino.toPath());
    }

    public static void copiar(File origen, File destino) throws IOException {
        Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void eliminar(File archivo) throws IOException {
        try (Stream<Path> rutas = Files.walk(archivo.toPath())) {
            List<Path> ordenadas = rutas.sorted(Comparator.reverseOrder()).toList();
            for (Path p : ordenadas) Files.delete(p);
        }
    }

    public static void comprimir(File carpeta, File zip) throws IOException {
        Path base = carpeta.toPath().getParent() != null ? carpeta.toPath().getParent() : carpeta.toPath();
        try (OutputStream salida = Files.newOutputStream(zip.toPath());
             ZipOutputStream zos = new ZipOutputStream(salida);
             Stream<Path> rutas = Files.walk(carpeta.toPath())) {
            for (Path p : (Iterable<Path>) rutas::iterator) {
                if (p.equals(zip.toPath())) continue;
                String nombre = base.relativize(p).toString().replace(File.separatorChar, '/');
                if (Files.isDirectory(p)) {
                    zos.putNextEntry(new ZipEntry(nombre + "/"));
                } else {
                    zos.putNextEntry(new ZipEntry(nombre));
                    Files.copy(p, zos);
                }
                zos.closeEntry();
            }
        }
    }

    public static boolean contiene(File carpeta, File archivo) {
        Path c = carpeta.toPath().toAbsolutePath().normalize();
        Path a = archivo.toPath().toAbsolutePath().normalize();
        return a.startsWith(c);
    }

    public static boolean mismoArchivo(File a, File b) {
        return a != null && b != null
                && a.toPath().toAbsolutePath().normalize().equals(b.toPath().toAbsolutePath().normalize());
    }
}
