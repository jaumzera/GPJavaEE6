package gpjavaee6.book.utils;

import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

/**
 *
 * @author http://stackoverflow.com/questions/2324937/code-to-list-all-the-entries-in-jndi-on-remote-machine
 */
public class JNDIUtils {

    public static Map<String, Object> toMap(Context ctx, int level) throws NamingException {
        String namespace = ctx instanceof InitialContext ? ctx.getNameInNamespace() : "";
        HashMap<String, Object> map = new HashMap<String, Object>();
        System.out.println(ident(level) + "> Listing namespace: " + namespace);
        NamingEnumeration<NameClassPair> list = ctx.list(namespace);
        while (list.hasMoreElements()) {
            NameClassPair next = list.next();
            String name = next.getName();
            String jndiPath = namespace + name;
            Object lookup;
            try {
                System.out.println(ident(level) + "> Looking up name: " + jndiPath);
                Object tmp = ctx.lookup(jndiPath);
                if (tmp instanceof Context) {
                    lookup = toMap((Context) tmp, ++level);
                } else {
                    lookup = tmp.toString();
                }
            } catch (Throwable t) {
                lookup = t.getMessage();
            }
            map.put(name, lookup);
        }
        return map;
    }

    public static String ident(int level) {
        String identation = "+";
        for (int i = 0; i < level; i++) {
            identation += "-";
        }
        return identation;
    }
    
}
