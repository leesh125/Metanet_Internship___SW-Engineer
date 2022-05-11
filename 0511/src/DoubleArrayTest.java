
public class DoubleArrayTest {

	public static void main(String[] args) {
		int[][] score = new int[][] {
			{80,75,60}, // 1반 학생들의 국어점수
			{90,88,98}, // 1반 학생들의 국어점수
			{80,77,85}  // 1반 학생들의 국어점수
		};
		int tmp_score,sum = 0, total_student = 0;
		// 각 반의 국어 평균과, 전체 학생의 국어 평균 구하기
		for(int i=0; i<score.length; i++) {
			tmp_score = 0;
			for(int num: score[i]) {
				tmp_score += num;
				total_student += 1;
			}
			System.out.printf("%d반의 국어 평균 점수: %.1f\n",(i+10), (double)tmp_score/score[i].length);
			sum += tmp_score;
		}
		System.out.printf("전체 학생 국어 평균 점수: %.1f",  (double)sum/total_student);
	}

}
