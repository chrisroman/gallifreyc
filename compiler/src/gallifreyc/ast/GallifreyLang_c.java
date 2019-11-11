package gallifreyc.ast;

import polyglot.ast.*;
import polyglot.util.InternalCompilerError;

public class GallifreyLang_c extends JLang_c implements GallifreyLang {
    public static final GallifreyLang_c instance = new GallifreyLang_c();

    public static GallifreyLang lang(NodeOps n) {
        while (n != null) {
            Lang lang = n.lang();
            if (lang instanceof GallifreyLang) return (GallifreyLang) lang;
            if (n instanceof Ext)
                n = ((Ext) n).pred();
            else return null;
        }
        throw new InternalCompilerError("Impossible to reach");
    }

    protected GallifreyLang_c() {
    }

    protected static GallifreyExt gallifreycExt(Node n) {
        return GallifreyExt.ext(n);
    }

    @Override
    protected NodeOps NodeOps(Node n) {
        return gallifreycExt(n);
    }

    // TODO:  Implement dispatch methods for new AST operations.
    // TODO:  Override *Ops methods for AST nodes with new extension nodes.
}