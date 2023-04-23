package mapper.identifiers.classes

import mapper.abstractclasses.IdentityMapper
import mapper.abstractclasses.OrderMapper
import mapper.annotations.DependsOn
import mapper.annotations.MethodParameters
import mapper.predicateutilities.and
import mapper.predicateutilities.predicateOf
import mapper.wrappers.Class2
import mapper.wrappers.Instruction2
import mapper.wrappers.Method2
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import org.runestar.client.common.startsWith

@DependsOn(PlatformInfoProvider::class)
class DesktopPlatformInfoProvider : IdentityMapper.Class() {
    override val predicate = predicateOf<Class2> { it.interfaces.contains(type<PlatformInfoProvider>()) }

    // mac, windows, linux, other
//    class osType : OrderMapper.InConstructor.Field(DesktopPlatformInfoProvider::class, 0) {
//        override val predicate = predicateOf<Instruction2> { it.opcode == Opcodes.PUTFIELD && it.fieldType == Type.INT_TYPE }
//    }

//     is amd64 or x86_64
//    class isX64 : OrderMapper.InConstructor.Field(DesktopPlatformInfoProvider::class, 0) {
//        override val predicate = predicateOf<Instruction2> { it.opcode == Opcodes.PUTFIELD && it.fieldType == Type.BOOLEAN_TYPE }
//    }

//    @DependsOn(osType::class)
//    class osVersionId : OrderMapper.InConstructor.Field(DesktopPlatformInfoProvider::class, 0) {
//        override val predicate = predicateOf<Instruction2> { it.opcode == Opcodes.PUTFIELD && it.fieldType == Type.INT_TYPE && it.fieldId != field<osType>().id }
//    }

//    @DependsOn(osType::class, osVersionId::class)
//    class javaVendorType : OrderMapper.InConstructor.Field(DesktopPlatformInfoProvider::class, 0) {
//        override val predicate = predicateOf<Instruction2> { it.opcode == Opcodes.PUTFIELD && it.fieldType == Type.INT_TYPE }
//                .and { it.fieldId != field<osType>().id }
//                .and { it.fieldId != field<osVersionId>().id }
//    }
//    @MethodParameters("buffer")
//    @DependsOn(Packet::class)
//    class write : IdentityMapper.InstanceMethod() {
//        override val predicate = predicateOf<Method2> { it.returnType == Type.VOID_TYPE }
//                .and { it.arguments.startsWith(type<Packet>()) }
//    }

//    @MethodParameters()
//    class limitStringLengths : IdentityMapper.InstanceMethod() {
//        override val predicate = predicateOf<Method2> { it.returnType == Type.VOID_TYPE }
//                .and { it.instructions.any { it.opcode == Opcodes.BIPUSH && it.intOperand == 40 } }
//    }

//    @MethodParameters()
//    class length : IdentityMapper.InstanceMethod() {
//        override val predicate = predicateOf<Method2> { it.returnType == Type.INT_TYPE }
//                .and { it.arguments.size in 0..1 }
//    }

//    class string0 : PlatformInfoString(0)
//    class string1 : PlatformInfoString(1)
//    class string2 : PlatformInfoString(2)
//    class string3 : PlatformInfoString(3)
//    class string4 : PlatformInfoString(4)
//    class string5 : PlatformInfoString(5)

//    @MethodParameters()
//    class get : IdentityMapper.InstanceMethod() {
//        override val predicate = predicateOf<Method2> { it.returnType != Type.VOID_TYPE }
//    }
}