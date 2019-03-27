package xyz.zhangyi.practicejava.annotation;

import java.lang.reflect.Field;

public interface Merging<T> {
    class InvalidReflectedFieldsException extends RuntimeException {
        public InvalidReflectedFieldsException(String message) {
            super(message);
        }
    }

    default void mergeWith(T newEntity) {
        Field[] newFields = newEntity.getClass().getDeclaredFields();
        Field[] oldFields = this.getClass().getDeclaredFields();

        try {
            validateReflectedFields(newFields, oldFields);
        } catch (InvalidReflectedFieldsException ex) {
            // todo: logging
            return;
        }

        for (int i = 0; i < oldFields.length; i++) {
            Field oldField = oldFields[i];
            Field newField = newFields[i];
            oldField.setAccessible(true);
            newField.setAccessible(true);

            MergeOn annotation = oldField.getAnnotation(MergeOn.class);
            try {
                if (annotation == null || annotation.level().isRequired()) {
                    resetIfNotNull(newEntity, oldField, newField);
                    continue;
                }
                if (annotation.level().isMandatory()) {
                    resetAnyway(newEntity, oldField, newField);
                }
            } catch (IllegalAccessException e) {
                // todo: logging
                e.printStackTrace();
            }
        }
    }

    default void validateReflectedFields(Field[] newFields, Field[] oldFields) {
        if (newFields == null || newFields.length == 0) {
            throw new InvalidReflectedFieldsException("no fields for new entity");
        }

        if (oldFields == null || oldFields.length == 0) {
            throw new InvalidReflectedFieldsException("no fields for old entity");
        }

        if (newFields.length != oldFields.length) {
            throw new InvalidReflectedFieldsException("fields of old entity not match with new entity");
        }
    }

    default void resetIfNotNull(T newEntity, Field oldField, Field newField) throws IllegalAccessException {
        Object newValue = newField.get(newEntity);
        if (newValue != null) {
            oldField.set(this, newValue);
        }
    }

    default void resetAnyway(T newEntity, Field oldField, Field newField) throws IllegalAccessException {
        Object newValue = newField.get(newEntity);
        oldField.set(this, newValue);
    }
}
