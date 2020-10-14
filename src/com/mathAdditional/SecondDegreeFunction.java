package com.mathAdditional;

import com.mathAdditional.Exceptions.InvalidValue;

public class SecondDegreeFunction {

    private final double a;
    private final double b;
    private final double c;

    public SecondDegreeFunction(double a, double b, double c) throws InvalidValue {
        this.a = a;
        this.b = b;
        this.c = c;

        if(a == 0)
            throw new InvalidValue("value 'a' cannot be zero");
    }

    public String[] calcFunction(boolean calculateComplex){
        boolean isLateral = false;

        double insideSq = Math.pow(b, 2) - (4 * a * c);
        double delta = Math.sqrt(insideSq);

        if(Double.isNaN(delta)){
            isLateral = true;
            delta = Math.sqrt(insideSq * -1);
        }

        if(isLateral){ // inComplexPlan
            if(!calculateComplex)
                return new String[]{"This function has no answer because delta is negative", ""};

            StringBuilder x1 = new StringBuilder();
            StringBuilder x2 = new StringBuilder();

            if((b * -1) % (2 * a) == 0 && delta % (2 * a) == 0){ // can divide p1 and p2 by 2*a

                double p1 = (b * -1) / (2 * a);
                double p2 = delta / (2 * a);

                if(p2 != 1){
                    x1.append(p1).append(" + ").append(p2).append("i");
                    x2.append(p1).append(" - ").append(p2).append("i");
                } else {
                    x1.append(p1).append(" + ").append("i");
                    x2.append(p1).append(" - ").append("i");
                }
            } else { // cannot divide p1 and p2 by 2*a
                x1.append("(").append(b * -1).append(" + ").append(delta).append("i) / ").append(2 * a);
                x2.append("(").append(b * -1).append(" + ").append(delta).append("i) / ").append(2 * a);
            }

            return new String[]{x1.toString(), x2.toString()};

        } else { // Not complex
            double x1 = ((b * -1) + delta) / (2 * a);
            double x2 = ((b * -1) - delta) / (2 * a);
            return new String[]{x1 + "", x2 + ""};
        }
    }

    public double[] calcFunction(){
        String[] result = calcFunction(false);

        if(result[1].equals(""))
            return new double[]{Double.NaN, Double.NaN};
        else
            return new double[]{Double.parseDouble(result[0]), Double.parseDouble(result[1])};
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("(%s)x² + (%s)x + (%s) = 0", a, b, c);
    }
}
