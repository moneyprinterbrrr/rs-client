package org.runestar.client.updater.mapper.identifiers.classes

import org.objectweb.asm.Type.*
import org.runestar.client.updater.mapper.abstractclasses.IdentityMapper
import org.runestar.client.updater.mapper.predicateutilities.and
import org.runestar.client.updater.mapper.predicateutilities.predicateOf
import org.runestar.client.updater.mapper.predicateutilities.type
import org.runestar.client.updater.mapper.wrappers.Class2

class VertexNormal : IdentityMapper.Class() {

    override val predicate = predicateOf<Class2> { it.superType == Any::class.type }
            .and { it.interfaces.isEmpty() }
            .and { it.instanceFields.count() == 4 }
            .and { it.instanceFields.all { it.type == INT_TYPE } }
            .and { it.instanceMethods.isEmpty() }
            .and { it.constructors.size == 2 }
}