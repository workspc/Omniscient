package sandbox.junit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import sandbox.junit.utils.Case;

/**
 * 
 * @author Gagandeep Singh
 *
 */
public class _001_CustomRule implements TestRule {

	@SuppressWarnings("unchecked")
	@Override
	public Statement apply(Statement base, Description description) {

		Class<Statement> statement = (Class<Statement>) base.getClass();
		Method[] statementMethods = statement.getMethods();
		for (Method method : statementMethods)
			System.out.println(method.getName());

		Annotation caseAnnotation = description.getAnnotation(Case.class);
		Collection<Annotation> annotations = description.getAnnotations();
		String displayName = description.getDisplayName();
		String className = description.getClassName();
		String methodName = description.getMethodName();

		System.out.println("Annot : " + caseAnnotation);
		System.out.println("Annots : " + annotations);
		System.out.println("Display : " + displayName);
		System.out.println("Class : " + className);
		System.out.println("Method : " + methodName);

		try {
			base.evaluate();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return base;
	}
}