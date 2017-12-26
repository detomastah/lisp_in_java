package parser;

public class RootObject extends ListObject {
	RootObject() {
		super(null);
	}

	@Override
	void print() {
		for (SyntaxObject s : items) {
			s.print();
		}
	}
}

