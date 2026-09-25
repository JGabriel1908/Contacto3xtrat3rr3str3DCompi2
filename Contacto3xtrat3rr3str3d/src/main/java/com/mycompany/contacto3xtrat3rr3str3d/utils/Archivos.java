package com.mycompany.contacto3xtrat3rr3str3d.utils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Operaciones sobre el sistema de archivos usadas por la IDE.
 */
public final class Archivos {

    private Archivos() {
    }

    public static String leer(File archivo) throws IOException {
        try {
            return Files.readString(archivo.toPath(), StandardCharsets.UTF_8);
        } catch (MalformedInputException e) {
            return Files.readString(archivo.toPath(), StandardCharsets.ISO_8859_1);
        }
    }

    public static void escribir(File archivo, String contenido) throws IOException {
        File padre = archivo.getParentFile();
        if (padre != null) Files.createDirectories(padre.toPath());
        Files.writeString(archivo.toPath(), contenido, StandardCharsets.UTF_8);
    }

    public static void mover(File origen, File destino) throws IOException {
        Files.move(origen.toPath(), destino.toPath());
    }

    public static void copiar(File origen, File destino) throws IOException {
        Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    /** Elimina un archivo o una carpeta con todo su contenido. */
    public static void eliminar(File archivo) throws IOException {
        try (Stream<Path> rutas = Files.walk(archivo.toPath())) {
            List<Path> ordenadas = rutas.sorted(Comparator.reverseOrder()).toList();
            for (Path p : ordenadas) Files.delete(p);
        }
    }

    /** Comprime una carpeta en un .zip; dentro del zip queda la carpeta con su nombre. */
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

    /** true si {@code archivo} es {@code carpeta} o está dentro de ella. */
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
