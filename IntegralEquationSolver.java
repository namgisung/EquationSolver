public class IntegralEquationSolver {
    // 수치적분을 계산하는 함수 (사다리꼴 법칙 사용)
    public static double integrate(double a, double b, int n) {
        double h = (b - a) / n;  // 구간의 폭
        double sum = 0.5 * (Math.exp(a) + Math.exp(b));  // 양 끝값의 평균

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += Math.exp(x);
        }

        return sum * h;
    }

    // 함수 f(x) 정의
    public static double f(double x) {
        return integrate(0, x, 1000) - 5; // 정적분 결과에서 5를 뺌
    }

    // 이진탐색 메소드
    public static double binarySearch(double left, double right, double tolerance) {
        double mid = left + (right - left) / 2.0;

        while ((right - left) / 2.0 > tolerance) {
            if (f(mid) == 0.0) {
                return mid; // 해를 정확히 찾은 경우
            } else if (f(left) * f(mid) < 0) {
                right = mid; // 해가 왼쪽 구간에 있는 경우
            } else {
                left = mid; // 해가 오른쪽 구간에 있는 경우
            }
            mid = left + (right - left) / 2.0;
        }

        return mid; // 근사값 반환
    }

    public static void main(String[] args) {
        // 초기 구간 설정 (예: [0, 3] 구간 내에서 해를 찾기)
        double left = 0.0;
        double right = 3.0;
        double tolerance = 1e-6; // 허용 오차

        // 이진탐색 호출
        double root = binarySearch(left, right, tolerance);

        System.out.printf("방정식의 근사 해는 %.6f입니다.\n", root);
    }
}
