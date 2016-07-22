package lck10_J_NCE;

import java.io.IOException;

//"Double-Checked Locking" idiom final 
class Foo {
	private Helper helper = null; 
	public Helper getHelper() {
		if (helper == null) { 
			synchronized (this) {
				if (helper == null) { 
					helper = new Helper(5);
				} 
			}
		}
	return helper; 
	}
//Other methods and members... 
	public void testCase(){
		Thread test = new Thread(new Runnable() {
			public void run() {
				Foo testF = new Foo();
				testF.getHelper();
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		testCase(); // starts thread 1 
		testCase(); // starts thread 2
	}
}
