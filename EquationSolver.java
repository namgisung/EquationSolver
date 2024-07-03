public class EquationSolver {
    // 함수 f(x) 정의
    public static double f(double x) {
        return x * x * x - 6 * x * x + 11 * x - 6; // 방정식
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
        // 초기 구간 설정
        double left = 1.0;
        double right = 3.0;
        double tolerance = 1e-6; // 허용 오차

        // 이진탐색 호출
        double root = binarySearch(left, right, tolerance);

        System.out.printf("방정식의 근사 해는 %.6f입니다.\n", root);
    }
}
