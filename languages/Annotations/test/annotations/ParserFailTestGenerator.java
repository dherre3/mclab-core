package annotations;


import java.io.IOException;
import java.io.PrintWriter;

/** Generates annotations.AnnotationParserFailTests from the provided list file. */
public class ParserFailTestGenerator extends AbstractTestGenerator {
	private ParserFailTestGenerator() {
		super("/annotations/AnnotationParserFailTests.java");
	}

	public static void main(String[] args) throws IOException {
		new ParserFailTestGenerator().generate(args);
	}

	protected void printHeader(PrintWriter testFileWriter) {
		testFileWriter.println("package annotations;");
		testFileWriter.println();
		testFileWriter.println("import java.util.ArrayList;");
		testFileWriter.println("import java.util.List;");
		testFileWriter.println();
		testFileWriter.println("import beaver.Parser;");
		testFileWriter.println();
		testFileWriter.println("public class AnnotationParserFailTests extends ParserFailTestBase {");
	}

	protected void printMethod(PrintWriter testFileWriter, String testName) {
		String methodName = "test_" + testName;
		String inFileName = "test/" + testName + ".in";
		String outFileName = "test/" + testName + ".out";
		testFileWriter.println();
		testFileWriter.println("	public void " + methodName + "() throws Exception {");
		testFileWriter.println("		List<String> expectedErrors = readErrors(\"" + outFileName + "\");");
		testFileWriter.println("		AnnotationScanner scanner = getScanner(\"" + inFileName + "\");");
		testFileWriter.println("		AnnotationParser parser = new AnnotationParser();");
		testFileWriter.println("		try {");
		testFileWriter.println("			parser.parse(scanner);");
		testFileWriter.println("			assertTrue(parser.hasError());");
		testFileWriter.println("			assertEquals(expectedErrors, parser.getErrors());");
		testFileWriter.println("		} catch(Parser.Exception e) {");
		testFileWriter.println("			List<String> actualErrors = new ArrayList<String>();");
		testFileWriter.println("			actualErrors.addAll(parser.getErrors());");
		testFileWriter.println("			actualErrors.add(e.getMessage());");
		testFileWriter.println("			assertEquals(expectedErrors, actualErrors);");
		testFileWriter.println("		}");
		testFileWriter.println("	}");
	}

	protected void printFooter(PrintWriter testFileWriter) {
		testFileWriter.println("}");
		testFileWriter.println();
	}
}
