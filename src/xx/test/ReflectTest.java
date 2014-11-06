package xx.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

	private String init;
	private Double db;

	private ReflectTest() {
		super();
	}

	private ReflectTest(String init, Double db) {
		super();
		this.init = init;
		this.db = db;
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public Double getDb() {
		return db;
	}

	public void setDb(Double db) {
		this.db = db;
	}

	public static void main(String[] args) throws Exception {
		// ReflectTest.contructor("xx.test.ReflectTest");
		// ReflectTest.methods("xx.test.ReflectTest");
		ReflectTest.filed("xx.test.ReflectTest");

		// Class<?> clazz = Class.forName("xx.test.ReflectTest") /* Integer.TYPE
		// */;
		// System.out.println(clazz.getName());
		// Object test = clazz.newInstance();
		// Object[] pas = new Object[1];
		// pas[0] = new Double(888);
		// Method method = clazz.getDeclaredMethod("setDb", Double.class);
		// System.out.println(method.invoke(test, pas));

	}

	public static void methods(String className) throws Exception {
		Class<?> clazz = Class.forName(className) /* Integer.TYPE */;

		System.out.println(clazz.getName());

		Method[] methods = clazz.getDeclaredMethods();

		Object test = clazz.newInstance();

		for (Method method : methods) {
			System.out.println("m name:" + method.getName());
			System.out.println("m dec class:" + method.getDeclaringClass());

			Class<?>[] paramT = method.getParameterTypes();
			Object[] pas = new Object[paramT.length];
			for (int i = 0; i < paramT.length; i++) {
				pas[i] = genInstance(paramT[i]);
				System.out.println("pram#" + paramT[i] + ",instance:" + pas[i]);
			}

			Class<?>[] exs = method.getExceptionTypes();
			for (Class<?> pc : exs) {
				System.out.println("exc#" + pc);
			}

			Class<?> returnType = method.getReturnType();
			System.out.println("Return Type:" + returnType);
			// System.out.println("method invoke:" + method.invoke(test,
			// paramT));
		}
	}

	private static Object genInstance(Class<?> clazz) {
		Object instance = null;
		try {
			if (clazz == String.class) {
				instance = "test";
			} else if (clazz == Double.class) {
				instance = new Double(999);
			} else {
				instance = clazz.newInstance();
			}
		} catch (InstantiationException ins) {

		} catch (IllegalAccessException e) {
		}
		return instance;
	}

	public static void contructor(String className) throws Exception {

		Class<?> clazz = Class.forName(className);

		Constructor<?>[] cons = clazz.getDeclaredConstructors();

		for (Constructor<?> c : cons) {
			System.out.println(c);
			System.out.println("con dec class:" + c.getDeclaringClass());
			System.out.println(c.getName() + ":");
			Class<?>[] paramT = c.getParameterTypes();
			for (Class<?> cz : paramT) {
				System.out.println("param:" + cz);
			}
			System.out.println("*********");
		}

	}

	public static void filed(String className) throws Exception {
		Class<?> clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field.getName());
			Object value = genInstance(field.getType());
			field.setAccessible(true);
			field.set(obj, value);
		}
		System.out.println(obj);
	}

	public boolean test(String name, float value) throws Exception {

		return false;
	}

	public String toString() {
		return "[init:" + init + ",db:" + db + "]";
	}

}
