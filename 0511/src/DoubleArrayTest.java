
public class DoubleArrayTest {

	public static void main(String[] args) {
		int[][] score = new int[][] {
			{80,75,60}, // 1�� �л����� ��������
			{90,88,98}, // 1�� �л����� ��������
			{80,77,85}  // 1�� �л����� ��������
		};
		int tmp_score,sum = 0, total_student = 0;
		// �� ���� ���� ��հ�, ��ü �л��� ���� ��� ���ϱ�
		for(int i=0; i<score.length; i++) {
			tmp_score = 0;
			for(int num: score[i]) {
				tmp_score += num;
				total_student += 1;
			}
			System.out.printf("%d���� ���� ��� ����: %.1f\n",(i+10), (double)tmp_score/score[i].length);
			sum += tmp_score;
		}
		System.out.printf("��ü �л� ���� ��� ����: %.1f",  (double)sum/total_student);
	}

}
