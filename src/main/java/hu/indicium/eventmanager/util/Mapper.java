package hu.indicium.eventmanager.util;

public interface Mapper<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);
}
