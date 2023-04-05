package com.yedam.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.users.UserService;

public class RecipeService extends UserService{
	
	Scanner sc = new Scanner(System.in);
	List<Recipe> list = new ArrayList<>();
	String title = null;
	
	//레시피 게시판
	public void recipeBoard() {
		int sel = 0;
		while(sel != 5) {
			list = RecipeDAO.getInstance().recipeList();
			System.out.println(" 글번호      제목         작성자       작성일 ");
			System.out.println("----------------------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getrTitle()+"\t		"+list.get(i).getuName()+"\t"+list.get(i).getrDate());
			}
			System.out.println("----------------------------------------------------");
			System.out.print("1.글읽기 | 2.새글쓰기 | 3.검색 | 4.글삭제 | 5.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			switch(sel) {
			case 2 :
				postRecipe();
				break;
			case 1 :
				readRecipe();
				break;
			case 3 :
				searchRecipe();
				break;
			case 4 :
				delRecipe();
				break;
			case 5 :
				break;
			}
		}
	}
	
	//레시피 게시판 - 글 작성
	public void postRecipe() {
		Recipe re = new Recipe();
		re.setuId(userInfo.getuId());
		re.setuName(userInfo.getuName());
		System.out.print("\n글 제목 > ");
		title = sc.nextLine();
		re.setrTitle(title);
		System.out.println("본문 >	(작성을 끝내시려면 '/완료' 를 입력하세요.)");
		System.out.println("");
		String body = "";
		while(true) {
			String temp = sc.nextLine();
			if(temp.equals("/완료")) {
				break;
			}else {
				body += temp + "\n ";
			}
		}
		re.setrBody(body);
		
		int result = RecipeDAO.getInstance().postRecipe(re);
		if(result > 0) {
			System.out.println("글 작성 완료");
			postCheck();
			autoLike();
		}else {
			System.out.println("글 작성 실패. 오류가 지속되면 관리자에게 문의하세요.");
		}
	}
	
	//레시피 게시판- 글읽기
	public void readRecipe() {
		Recipe re = new Recipe();
		while(true) {
			System.out.print("조회할 글 번호 > ");
			int num = Integer.parseInt(sc.nextLine());
			re = list.get(num-1);
			int like = RecipeDAO.getInstance().countLike(re.getrId());
			System.out.println("============================================");
			System.out.println(" 제목 : " +re.getrTitle());
			System.out.println(" "+re.getuName()+"		"+re.getrDate());
			System.out.println("--------------------------------------------");
			System.out.println(" "+re.getrBody());
			System.out.println("                  \t   좋아요 "+ (like-1) +"개");
			System.out.println("============================================");
			System.out.print("1.♥좋아요누르기♥ 2.뒤로가기");
			if(Integer.parseInt(sc.nextLine()) == 1) {
				int result = RecipeDAO.getInstance().addLike(re.getrId(), userInfo.getuId());
				if(result > 0) {
					System.out.println("좋아요 완료!");
				}else {
					System.out.println("오류가 발생하였습니다.");
				}
				break;
			}else {
				break;
			}
		}	
	}
	
	//레시피게시판 - 검색
	//1. 제목으로 검색. | 2. 작성자로 검색
	public void searchRecipe() {
		System.out.println("1.제목으로 검색 | 2.작성자로 검색");
		if(sc.nextLine().equals("1")) {
			System.out.println("키워드를 입력하세요 > ");
			list = RecipeDAO.getInstance().recipeSearch2(sc.nextLine());
		}else {
			System.out.println("닉네임을 입력하세요 > ");
			list = RecipeDAO.getInstance().recipeSearch1(sc.nextLine());
		}
		int sel = 0;
		while(sel != 2) {
			System.out.println(" 글번호       제목        작성자      작성일 ");
			System.out.println("----------------------------------------------------");
			for(int i=0; i<list.size(); i++) {
				System.out.println("  "+(i+1)+"   "+list.get(i).getrTitle()+"		"+list.get(i).getuName()+"  "+list.get(i).getrDate());
			}
			System.out.println("----------------------------------------------------");
			System.out.println("1.글읽기 | 2.글삭제 | 3.뒤로가기");
			sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				readRecipe();
			}else if(sel == 2) {
				delRecipe();
			}else {
				break;
			}
		}
	}
	
	//레시피 게시판 - 글 삭제
	public void delRecipe() {
		Recipe a = new Recipe();
		System.out.print("삭제할 글 번호 > ");
		int num = Integer.parseInt(sc.nextLine());
		a = list.get(num-1);
		if(a.getuId().equals(userInfo.getuId()) || userInfo.getuGrade().equals("a")){
			int result = RecipeDAO.getInstance().delRecipe(a);
			if(result>0) {
				System.out.println("작성글이 삭제되었습니다.");
			}else {
				System.out.println("글 삭제중 오류가 발생하였습니다.");
			}
		}else {
			System.out.println("본인이 작성한 글만 삭제할 수 있습니다.");
		}
	}
	
	//자동 좋아요
	public void autoLike() {
		list = RecipeDAO.getInstance().recipeSearch2(title);
		Recipe re = list.get(0);
		int result = RecipeDAO.getInstance().addLike(re.getrId(), re.getuId());
		if(result == 0) {
			System.out.println("오류가 발생하였습니다.");
		}
	}
}
