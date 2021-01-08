package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.exceptions.AnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] declaredFields = clazz.getDeclaredFields();
        validate();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType() == BetDao.class) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType() == UserDao.class) {
                    field.set(instance, Factory.getUserDao());
                }
            }
        }
        return instance;
    }

    private static void validate() {
        if (BetDaoImpl.class.isAnnotationPresent(Dao.class)
                && UserDaoImpl.class.isAnnotationPresent(Dao.class)) {
            return;
        }
        throw new AnnotationException("THIS IS STILL IN BETA, "
                + "CONTACT CEO FOR FURTHER INFORMATION ");
    }
}
