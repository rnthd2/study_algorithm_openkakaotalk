package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class le2 {
   
   public static int max=Integer.MIN_VALUE;
   static LinkedList<String> list = new LinkedList<String>();
   
   public static void main(String[] args) {

      String num = "500+500-700*900-100";

      
      
      String[] tocken1 = num.split("\\+|\\-|\\*"); 
      // 숫자만 추출
      System.out.println(Arrays.toString(tocken1));
      
      
      String[] tocken2 = num.replaceAll("[0-9]", "").split("");
      // 연산자 추출
      System.out.println(Arrays.toString(tocken2));
      
      
      for(int i=0 ; i<tocken2.length ; i++) {
         list.add(tocken1[i]);
         list.add(tocken2[i]);
      }
      list.add(tocken1[tocken1.length-1]);
      // 리스트에 순차적으로 넣기
      
      String[] oper= {"+","-","*"}; 
      perm(oper,0);
      
      System.out.println(max);

      
      
   
   }
   
   public static void Start(String[] oper) {
      LinkedList<String> list_clone = (LinkedList<String>) list.clone();
      // 깊은복사를 통해 새로운 list 생성
      for(int i=0 ; i<oper.length ; i++) {
         while(list_clone.indexOf(oper[i])!=-1) {
            Operation(list_clone, oper[i]);
         }
      }
      System.out.println(list_clone.toString());
      max=Math.max(max, Integer.parseInt(list_clone.get(0)));
   }
   
   
   
   public static void Operation(LinkedList<String> list,String op) {
      //  계산
      
      int idx= list.indexOf(op);
      int num1=Integer.parseInt(list.get(list.indexOf(op)+1));
      int num2=Integer.parseInt(list.get(list.indexOf(op)-1));
      String num3="";
      
      if(op.equals("+")) {
         num3=Integer.toString(num1+num2);
      }else if(op.equals("-")) {
         num3=Integer.toString(num1-num2);
      }else {
         num3=Integer.toString(num1*num2);
      }
      
      
      for(int i=0 ; i<3 ; i++) {
         list.remove(idx-1);
      }
      list.add(idx-1,num3);
         
         
      
      
   }
   
   public static void perm(String[] oper , int depth) {
      // 순열로 우선순위 정하기
      
      if(depth==oper.length) {
         //System.out.println(Arrays.toString(oper));
         Start(oper);
         return;
      }
      for(int i=depth ; i<oper.length ; i++) {

         swap(oper,depth,i);
         perm(oper,depth+1);
         swap(oper,depth,i);
      }
      
   }
   
   public static void swap(String[] oper , int a , int b) {
      // 순열에 필요한 swap
      String tmp=oper[a];
      oper[a]=oper[b];
      oper[b]=tmp;
      
      
   }
   

   


}