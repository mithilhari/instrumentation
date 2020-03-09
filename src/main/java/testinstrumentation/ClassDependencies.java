package testinstrumentation;

import javassist.bytecode.ConstPool;
import org.apache.bcel.*;
import org.apache.bcel.classfile.*;

import java.io.*;
import java.util.*;


public class ClassDependencies {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        try {
            InputStream is = SimpleMain.class.getResourceAsStream("SimpleMain.class");
            set = getDependencies(is);
            } catch (Exception e) {
        }
        System.out.println(set);
//                .forEachOrdered(System.out::println);
    }
    private static Set<String> getDependencies(InputStream is) throws IOException {
        JavaClass cf = new ClassParser(is, "").parse();
        final ConstantPool constPool = cf.getConstantPool();
        final HashSet<String> set = new HashSet<String>();
        constPool.accept(new DescendingVisitor(cf, new EmptyVisitor() {
            @Override public void visitConstantClass(ConstantClass cC) {
                set.add(((String)cC.getConstantValue(constPool)).replace('/', '.'));
            }
            @Override public void visitConstantNameAndType(ConstantNameAndType cNaT) {
                processSignature(cNaT.getSignature(constPool));
            }
            @Override public void visitConstantMethodType(ConstantMethodType cMt) {
                processSignature(
                        constPool.constantToString(cMt.getDescriptorIndex(),
                                (byte) ConstPool.CONST_Utf8));
            }
            private void processSignature(String desc) {
                for(int p = 0; p<desc.length(); p++)
                    if(desc.charAt(p)=='L')
                        set.add(desc.substring(++p, p=desc.indexOf(';', p)).replace('/', '.'));
            }
        }));
        return set;
    }
}
