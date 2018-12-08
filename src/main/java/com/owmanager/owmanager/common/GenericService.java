/**
 * 
 */
package com.owmanager.owmanager.common;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author Damien
 *
 */
public abstract class GenericService<T extends Entitable,ID extends Serializable> {

	public T findOne(ID serializable) {
		Assert.isTrue(!StringUtils.isEmpty(serializable),
				"This param id is null when i call GenericService.findOne(Serializable serializable)");
		return repository().findOne(serializable);
	}

	public T create(T object) {
		Assert.notNull(object, "This object param is null when i call GenericService.create(T object)");
		return repository().save(object);
	}

	public void delete(ID serializable) {
		Assert.isTrue(!StringUtils.isEmpty(serializable),
				"This param id is null when i call GenericService.findOne(Serializable serializable)");
		repository().delete(serializable);
	}

	public T update(T object, Serializable id) {
		Assert.isTrue(!StringUtils.isEmpty(id),
				"This param id is null when i call GenericService.update(T object,Serializable id)");
		Assert.notNull(object, "This object param is null when i call GenericService.create(T object)");
		if (!object.getMongoId().equals(id)) {
			throw new OWException("L'id de l'objet qui doit être mis à jour n'est pas le même que celui de l'url.");
		}
		return repository().save(object);
	}

	protected abstract MongoRepository<T, ID> repository();
}
