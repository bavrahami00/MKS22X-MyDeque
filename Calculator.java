public class Calculator {
  public static double eval(String s) {
    MyDeque<Double> stack = new MyDeque<Double>();
    String t = ""+s.charAt(0);
    for (int x = 1; x < s.length(); x++) {
      if (s.charAt(x) != ' ') {
        t += s.charAt(x);
      }
      else {
        edit(t,stack);
        t = "";
      }
    }
    edit(t,stack);
    return stack.getFirst();
  }
  private static void edit(String t, MyDeque<Double> stack) {
    try {
      stack.addLast(Double.parseDouble(t));
    }
    catch (NumberFormatException n) {
      double second = stack.removeLast();
      double first = stack.removeLast();
      if (t.equals("+")) {
        stack.addLast(first+second);
      }
      else if (t.equals("*")) {
        stack.addLast(first*second);
      }
      else if (t.equals("-")) {
        stack.addLast(first-second);
      }
      else if (t.equals("/")) {
        stack.addLast(first+second);
      }
      else if (t.equals("%")) {
        stack.addLast(first%second);
      }
    }
  }
}
