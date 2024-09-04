package io.github.octopus.jpa

import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class PersistableBase<PK> : Persistable<PK> {
    @Id
    private var id: PK? = null

    @Transient
    private var creatingNew = false;

    override fun isNew() = creatingNew;

    override fun toString() = "Entity-${javaClass.name}(id=$id)"
}
