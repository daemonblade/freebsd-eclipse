package trycatch18_in;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class TestWithThrows3 {
	public FileInputStream foo(int a) throws FileNotFoundException {
		try (/*[*/ FileInputStream f = new FileInputStream("a.b")) {
			return f;/*]*/
		} catch (FileNotFoundException e) {
			// do nothing
		} catch (IOException e) {
		}
		return null;
	}
}
