package game;

import java.util.Scanner;

public class Lucky {

	static String[] userName = new String[10];
	static String[] passWord = new String[10];
	static int[] userId = new int[10];
	static String userName_1;
	static String passWord_1;
	static int key;
	static int adj = 0;
	static int[] num = new int[5];
	static int k = 0;
	static String str = "";
	static Scanner input = new Scanner(System.in);
	static Lucky index = new Lucky();

	// ���˳齱
	public void Welcome() {
		System.out.println("*****��ӭ���뽱�͸���ϵͳ*****");
		System.out.println("*         1.ע��                                *");
		System.out.println("*         2.��¼                                *");
		System.out.println("*         3.�齱                                *");
		System.out.println("*****************************");
		System.out.print("��ѡ��˵�:");
	}

	// ע�Ṧ��
	public void Register() {
		System.out.println("[���͸���ϵͳ>ע�� ]");
		System.out.println("����д����ע����Ϣ��");
		for (int i = 0; i < 10; i++) {
			if(userName[i]==null){
				index = i ;
			}
			System.out.print("�û���:");
			userName[index] = input.next();
			System.out.print("��     �룺");
			passWord[i] = input.next();
			System.out.println("");
			System.out.println("");
			System.out.println("ע��ɹ�����Ǻ����Ļ�Ա����");
			System.out.println("�û���   ����   ��Ա���� ");
			System.out.print(userName[i] + "  ");
			System.out.print(passWord[i] + "  ");
			userId[i] = (int) (Math.random() * 9999) + 1;
			userId[i] = (int) userId[i];
			System.out.print(userId[i]);
			break;
		}
	}

	// ��¼����
	public void Login() {
		System.out.println("[���͸���ϵͳ>��¼ ]");
		System.out.print("�������û�����");
		userName_1 = input.next();
		System.out.print("��������     �룺");
		passWord_1 = input.next();
		for (int i = 0; i < 10; i++) {
			if (k != 3) {
				if (userName_1.equals(userName[i])) {
					if (passWord_1.equals(userName[i])) {
						System.out.println("��ӭ����" + userName[i]);
						break;
					} else {
						System.out.println("�������");
						k++;
					}
				} else {
					System.out.println("�û�������");
					k++;
				}
			} else {
				System.out.println("���ĵ�¼�������Σ�������ѡ��");
			}
		}
	}

	// �齱����
	public void Raffle() {
		System.out.println("[���͸���ϵͳ>�齱 ]");
		for (int i = 0; i < 10; i++) {
			if (userName_1.equals(userName[i])) {
				System.out.print("���Ŀ��ţ�");
				System.out.println(userId[i]);
				System.out.println("���յ���������Ϊ��");
				if(i<5){
				System.out.print(num[i] = (int) (Math.random() *9999)+1);
				}
				if (userId[i] == num[i]) {
					System.out.println("���Ǳ��յ����˻�Ա��");
				} else {
					System.out.println("��Ǹ�������Ǳ��յ����˻�Ա��");
				}
				break;
			}
		}
	}

	// ϵͳ�Ƿ����
	public void Proceed() {

		String ch;
		ch = input.next();
		System.out.print("������(y/n):");
		if (ch.equals("y")) {
			index.xunhuan();
		} else {
			System.out.println("ϵͳ�˳���ллʹ��");
			System.exit(0);
		}
	}

	// ѭ������
	public void xunhuan() {

		index.Welcome();
		key = input.nextInt();
		switch (key) {
		case 1:
			index.Register();

		case 2:
			index.Login();
			adj = 1;
			index.Proceed();
		case 3:
			if (adj == 1) {
				index.Raffle();
				adj = 0;
				index.Proceed();
			} else {
				System.out.println("������¼֮����д˲���");
			}
		default:
			System.out.println("�����������");
			index.xunhuan();
		}
	}

	// ������
	public static void main(String[] args) {
		index.xunhuan();
	}

}
