public class Calculator {
  public static double eval(String s) {
    MyDeque<Double> stack = new MyDeque<Double>();
    String t = ""+s.charAt(0);
    for (int x = 1; x <= s.length(); x++) {
      if (x == s.length() || s.charAt(x) == ' ') {
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
        t = "";
      }
      else {
        t += s.charAt(x);
      }
    }
    return stack.getFirst();
  }
}
