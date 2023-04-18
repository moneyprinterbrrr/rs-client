package org.runestar.client.updater.mapper.identifiers.classes

import org.runestar.client.common.startsWith
import org.objectweb.asm.Opcodes.*
import org.objectweb.asm.Type.*
import org.runestar.client.updater.mapper.abstractclasses.IdentityMapper
import org.runestar.client.updater.mapper.abstractclasses.OrderMapper
import org.runestar.client.updater.mapper.abstractclasses.UniqueMapper
import org.runestar.client.updater.mapper.annotations.DependsOn
import org.runestar.client.updater.mapper.annotations.MethodParameters
import org.runestar.client.updater.mapper.predicateutilities.and
import org.runestar.client.updater.mapper.predicateutilities.predicateOf
import org.runestar.client.updater.mapper.predicateutilities.type
import org.runestar.client.updater.mapper.predicateutilities.withDimensions
import org.runestar.client.updater.mapper.predicateutilities.prevIn
import org.runestar.client.updater.mapper.wrappers.Class2
import org.runestar.client.updater.mapper.wrappers.Field2
import org.runestar.client.updater.mapper.wrappers.Instruction2
import org.runestar.client.updater.mapper.wrappers.Method2
import java.lang.reflect.Modifier

@DependsOn(DualNode::class, NPCType::class)
class LocType : IdentityMapper.Class() {
    override val predicate = predicateOf<Class2> { it.superType == type<DualNode>() }
            .and { it.interfaces.isEmpty() }
            .and { it.instanceFields.count { it.type == String::class.type } == 1 }
            .and { it.instanceFields.count { it.type == String::class.type.withDimensions(1) } == 1 }
            .and { it.instanceFields.count { it.type == ShortArray::class.type } == 4 }
            .and { it.type != type<NPCType>() }

    class name : IdentityMapper.InstanceField() {
        override val predicate = predicateOf<Field2> { it.type == String::class.type }
    }

    class op : IdentityMapper.InstanceField() {
        override val predicate = predicateOf<Field2> { it.type == String::class.type.withDimensions(1) }
    }

    @DependsOn(Packet::class)
    class decode : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(type<Packet>()) }
                .and { it.instructions.none { it.opcode == BIPUSH && it.intOperand == 23 } }
    }

    @DependsOn(Packet::class)
    class decode0 : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == VOID_TYPE }
                .and { it.arguments.startsWith(type<Packet>()) }
                .and { it.instructions.any { it.opcode == BIPUSH && it.intOperand == 23 } }
    }

    @DependsOn(Client.getLocType::class)
    class id : OrderMapper.InMethod.Field(Client.getLocType::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE && it.fieldOwner == type<LocType>() }
    }

    @MethodParameters()
    class multiLoc : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == type<LocType>() }
    }

    @DependsOn(multiLoc::class)
    class multi : UniqueMapper.InMethod.Field(multiLoc::class) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == IntArray::class.type }
    }

    @DependsOn(multiLoc::class)
    class multiVarbit : OrderMapper.InMethod.Field(multiLoc::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == INT_TYPE }
    }

    @DependsOn(multiLoc::class)
    class multiVar : OrderMapper.InMethod.Field(multiLoc::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == INT_TYPE }
    }

    class width : OrderMapper.InConstructor.Field(LocType::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class length : OrderMapper.InConstructor.Field(LocType::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class interactType : OrderMapper.InConstructor.Field(LocType::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class boolean1 : OrderMapper.InConstructor.Field(LocType::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class interactable : OrderMapper.InConstructor.Field(LocType::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class hillChange : OrderMapper.InConstructor.Field(LocType::class, 4) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class sharelight : OrderMapper.InConstructor.Field(LocType::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class occlude : OrderMapper.InConstructor.Field(LocType::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class animationId : OrderMapper.InConstructor.Field(LocType::class, 5) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int2 : OrderMapper.InConstructor.Field(LocType::class, 6) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class ambient : OrderMapper.InConstructor.Field(LocType::class, 7) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class contrast : OrderMapper.InConstructor.Field(LocType::class, 8) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class mapIconId : OrderMapper.InConstructor.Field(LocType::class, 9) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class mapSceneId : OrderMapper.InConstructor.Field(LocType::class, 10) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class isRotated : OrderMapper.InConstructor.Field(LocType::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class clipped : OrderMapper.InConstructor.Field(LocType::class, 4) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class resizeX : OrderMapper.InConstructor.Field(LocType::class, 11) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class resizeY : OrderMapper.InConstructor.Field(LocType::class, 12) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class resizeZ : OrderMapper.InConstructor.Field(LocType::class, 13) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class offsetX : OrderMapper.InConstructor.Field(LocType::class, 14) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class offsetY : OrderMapper.InConstructor.Field(LocType::class, 15) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class offsetZ : OrderMapper.InConstructor.Field(LocType::class, 16) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class lowDetailVisible : OrderMapper.InConstructor.Field(LocType::class, 5) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class isSolid : OrderMapper.InConstructor.Field(LocType::class, 6) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == BOOLEAN_TYPE }
    }

    class int3 : OrderMapper.InConstructor.Field(LocType::class, 17) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class ambientSoundId : OrderMapper.InConstructor.Field(LocType::class, 20) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int4 : OrderMapper.InConstructor.Field(LocType::class, 21) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int5 : OrderMapper.InConstructor.Field(LocType::class, 22) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    class int6 : OrderMapper.InConstructor.Field(LocType::class, 23) {
        override val predicate = predicateOf<Instruction2> { it.opcode == PUTFIELD && it.fieldType == INT_TYPE }
    }

    @MethodParameters()
    @DependsOn(Client.getLocType::class)
    class postDecode : OrderMapper.InMethod.Method(Client.getLocType::class, -1) {
        override val predicate = predicateOf<Instruction2> { it.isMethod && it.methodOwner == type<LocType>() }
    }

    @DependsOn(Model::class)
    class getModel : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == type<Model>() }
                .and { it.arguments.size in 6..7 }
    }

    @DependsOn(Model::class)
    class getModelDynamic : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == type<Model>() }
                .and { it.arguments.size in 8..9 }
    }

    @MethodParameters("n", "m")
    @DependsOn(UnlitModel::class)
    class getUnlitModel : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == type<UnlitModel>() }
    }

    @DependsOn(getUnlitModel::class)
    class recol_s : OrderMapper.InMethod.Field(getUnlitModel::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == SALOAD }
                .prevIn(2) { it.opcode == GETFIELD && it.fieldType == ShortArray::class.type }
    }

    @DependsOn(getUnlitModel::class)
    class recol_d : OrderMapper.InMethod.Field(getUnlitModel::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == SALOAD }
                .prevIn(2) { it.opcode == GETFIELD && it.fieldType == ShortArray::class.type }
    }

    @DependsOn(getUnlitModel::class)
    class retex_s : OrderMapper.InMethod.Field(getUnlitModel::class, 2) {
        override val predicate = predicateOf<Instruction2> { it.opcode == SALOAD }
                .prevIn(2) { it.opcode == GETFIELD && it.fieldType == ShortArray::class.type }
    }

    @DependsOn(getUnlitModel::class)
    class retex_d : OrderMapper.InMethod.Field(getUnlitModel::class, 3) {
        override val predicate = predicateOf<Instruction2> { it.opcode == SALOAD }
                .prevIn(2) { it.opcode == GETFIELD && it.fieldType == ShortArray::class.type }
    }

    @DependsOn(IterableNodeHashTable::class)
    class params : IdentityMapper.InstanceField() {
        override val predicate = predicateOf<Field2> { it.type == type<IterableNodeHashTable>() }
    }

    class getIntParam : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == INT_TYPE }
                .and { it.arguments == listOf(INT_TYPE, INT_TYPE) }
    }

    class getStringParam : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == String::class.type }
                .and { it.arguments == listOf(INT_TYPE, String::class.type) }
    }

    @DependsOn(postDecode::class)
    class models : OrderMapper.InMethod.Field(postDecode::class, 0) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == IntArray::class.type }
    }

    @DependsOn(postDecode::class)
    class modelTypes : OrderMapper.InMethod.Field(postDecode::class, 1) {
        override val predicate = predicateOf<Instruction2> { it.opcode == GETFIELD && it.fieldType == IntArray::class.type }
    }

    class loadModels : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == BOOLEAN_TYPE && it.arguments.isEmpty() && Modifier.isFinal(it.access) }
    }

    class loadModelType : IdentityMapper.InstanceMethod() {
        override val predicate = predicateOf<Method2> { it.returnType == BOOLEAN_TYPE && it.arguments.size == 1 }
    }
}