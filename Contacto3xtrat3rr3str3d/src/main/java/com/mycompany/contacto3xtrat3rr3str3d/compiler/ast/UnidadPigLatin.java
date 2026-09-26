package com.mycompany.contacto3xtrat3rr3str3d.compiler.ast;

import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.declaraciones.Import;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.Bloque;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.ast.instrucciones.DeclaracionVariable;
import com.mycompany.contacto3xtrat3rr3str3d.compiler.semantic.ContextoSemantico;
import java.util.List;

public class UnidadPigLatin extends Unidad {

    private final List<Import> imports;
    private final List<DeclaracionVariable> globales;
    private final Bloque principal;

    public UnidadPigLatin(Ubicacion ubicacion, List<Import> imports,
                          List<DeclaracionVariable> globales, Bloque principal) {
        super(ubicacion);
        this.imports = List.copyOf(imports);
        this.globales = List.copyOf(globales);
        this.principal = principal;
    }

    public List<Import> getImports() {
        return imports;
    }

    @Override
    public void analizar(ContextoSemantico ctx) {
        ctx.setRetornoActual(null);
        globales.forEach(g -> g.analizar(ctx));
        principal.getInstrucciones().forEach(i -> i.analizar(ctx));
    }
}
