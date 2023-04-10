package identifiers;

import org.objectweb.asm.Type;
import utility.ClassWrapper;
import utility.TypeUtilities;

public class AnimFrameset extends AbstractIdentifier {
    @Override
    public boolean isMatch(ClassWrapper classNode) {
        return classNode.isSuperClassEquals("DualNode") &&
                classNode.getInstanceFields().size() == 1 &&
                classNode.getInstanceFields().stream().anyMatch(field -> Type.getObjectType(field.desc)
                        .equals(TypeUtilities.withDimensions(TypeUtilities.getTypeOfIdentifiedClass("AnimFrame"), 1)));
    }
}