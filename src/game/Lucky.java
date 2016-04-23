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

	// 幸运抽奖
	public void Welcome() {
		System.out.println("*****欢迎进入奖客富翁系统*****");
		System.out.println("*         1.注册                                *");
		System.out.println("*         2.登录                                *");
		System.out.println("*         3.抽奖                                *");
		System.out.println("*****************************");
		System.out.print("请选择菜单:");
	}

	// 注册功能
	public void Register() {
		System.out.println("[奖客富翁系统>注册 ]");
		System.out.println("请填写个人注册信息：");
		for (int i = 0; i < 10; i++) {
			if(userName[i]==null){
				index = i ;
			}
			System.out.print("用户名:");
			userName[index] = input.next();
			System.out.print("密     码：");
			passWord[i] = input.next();
			System.out.println("");
			System.out.println("");
			System.out.println("注册成功，请记好您的会员卡号");
			System.out.println("用户名   密码   会员卡号 ");
			System.out.print(userName[i] + "  ");
			System.out.print(passWord[i] + "  ");
			userId[i] = (int) (Math.random() * 9999) + 1;
			userId[i] = (int) userId[i];
			System.out.print(userId[i]);
			break;
		}
	}

	// 登录功能
	public void Login() {
		System.out.println("[奖客富翁系统>登录 ]");
		System.out.print("请输入用户名：");
		userName_1 = input.next();
		System.out.print("请输入密     码：");
		passWord_1 = input.next();
		for (int i = 0; i < 10; i++) {
			if (k != 3) {
				if (userName_1.equals(userName[i])) {
					if (passWord_1.equals(userName[i])) {
						System.out.println("欢迎您：" + userName[i]);
						break;
					} else {
						System.out.println("密码错误");
						k++;
					}
				} else {
					System.out.println("用户名错误");
					k++;
				}
			} else {
				System.out.println("您的登录超过三次，请重新选择");
			}
		}
	}

	// 抽奖功能
	public void Raffle() {
		System.out.println("[奖客富翁系统>抽奖 ]");
		for (int i = 0; i < 10; i++) {
			if (userName_1.equals(userName[i])) {
				System.out.print("您的卡号：");
				System.out.println(userId[i]);
				System.out.println("本日的幸运数字为：");
				if(i<5){
				System.out.print(num[i] = (int) (Math.random() *9999)+1);
				}
				if (userId[i] == num[i]) {
					System.out.println("您是本日的幸运会员！");
				} else {
					System.out.println("抱歉，您不是本日的幸运会员！");
				}
				break;
			}
		}
	}

	// 系统是否继续
	public void Proceed() {

		String ch;
		ch = input.next();
		System.out.print("继续吗？(y/n):");
		if (ch.equals("y")) {
			index.xunhuan();
		} else {
			System.out.println("系统退出，谢谢使用");
			System.exit(0);
		}
	}

	// 循环方法
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
				System.out.println("请您登录之后进行此操作");
			}
		default:
			System.out.println("您的输出有误！");
			index.xunhuan();
		}
	}

	// 主函数
	public static void main(String[] args) {
		index.xunhuan();
	}

}
