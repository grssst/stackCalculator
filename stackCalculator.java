import java.util.Scanner;

public class stackCalculator{
    public static void main(String[] args) {
        String[] stack_1=new String[40];
        String[] stack_2=new String[40];
        String[] stack_oper=new String[40];
        String[] stack_3=new String[40];     
        String[] stack_4=new String[40];
        String[] stack_5=new String[40];
        //String[] result=new String[40];
        String result;

        String input_data;
        int cnt_1,cnt_2;
        int num_1,num_2,num_3;
       

        Scanner useScanner = new Scanner(System.in);
        
        
        

        System.out.print("<후위 변환 계산기> ");
        while(true){


        
            
                for(int i=0; i<39; i++){
                    //stack_1[i]="x";
                    stack_2[i]="x";
                    stack_3[i]="x";
                    stack_4[i]="x";
                    stack_5[i]="x";
                    stack_oper[i]="x";
                   
                }
                cnt_1=0;
                cnt_2=0;
                
                
                

            System.out.print("\n중위 표기법 수식을 1자리 정수들과 연산자들의 조합으로 입력하세요(예시:1+4/2*8)\n입력 : ");
            input_data = useScanner.nextLine();
            
            stack_1=input_data.split("");          //입력받은 문자열을 한글자씩 분리하여 배열에 저장
            for(int i=0; i<stack_1.length; i++){
                stack_2[i]=stack_1[i];
            }
            System.out.print("괄호를 적용하여 표현합니다.\n");


         
            for(int i=0; i<30; i++){
                cnt_1=0;
                cnt_2=0;
                if(stack_2[i].equals("*") || stack_2[i].equals("/")){
                    System.out.print("");
                    if(i==1){
                        for(int j=30; j>=0; j--){
                            stack_2[j+1]=stack_2[j];
                        }
                        for(int k=30; k>=4; k--){
                            stack_2[k+1]=stack_2[k];
                        }
                        stack_2[0]="(";
                        stack_2[4]=")";
                        i=i+3;
                    }
                    else{
                        for(int y=i; y>=0; y--){   
                            if(stack_2[y].equals(")")){
                                cnt_1=cnt_1+1;
                            }
                            else if(stack_2[y].equals("(")){
                                cnt_2=cnt_2+1;
                            }
                        
                            if(stack_2[i-2].equals("+") || stack_2[i-2].equals("-")){
                                for(int q=30; q>=i-1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[i-1]="(";
                                cnt_1=0;
                                cnt_2=0;
                                i=i+1;
                                
                                break;
                            }
                            
                            if(cnt_1==cnt_2 && cnt_1!=0){
                                for(int q=30; q>=y; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[y]="(";
                                i=i+1;
                                
                                break;
                            }
                            
                        }
                        i=i+1;
                        cnt_1=0;
                        cnt_2=0;
                        for(int y=i; y<30; y++){     
                            if(stack_2[y].equals("(")){
                                cnt_1=cnt_1+1;
                            }
                            else if(stack_2[y].equals(")")){
                                cnt_2=cnt_2+1;
                            }
                             else if(stack_2[y].equals("+")==false && stack_2[i].equals("-")==false && stack_2[y].equals("x")==false && stack_2[i+1].equals("(")==false){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                
                                stack_2[y+1]=")";
                                i=i+1;
                                
                                break;
                            }
                           
                            if(cnt_1==cnt_2 && cnt_1!=0){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[y+1]=")";
                                i=i+1;
                                break;
                            }
                            
                        }
                        
                    }
                }
            }
            
            for(int i=0; i<30; i++){
                cnt_1=0;
                cnt_2=0;
                if(stack_2[i].equals("+") || stack_2[i].equals("-")){
                    
                    if(i==1){
                        if(stack_2[i+1].equals("(") || stack_2[i+1].equals(")")){
                            for(int j=30; j>=0; j--){
                                stack_2[j+1]=stack_2[j];
                            }
                            stack_2[0]="(";
                            i=i+2;
                            cnt_1=0;
                        cnt_2=0;
                        for(int y=i; y<30; y++){      
                            if(stack_2[y].equals("(")){
                                cnt_1=cnt_1+1;
                            }
                            else if(stack_2[y].equals(")")){
                                cnt_2=cnt_2+1;
                            }
                             else if(stack_2[y].equals("*")==false && stack_2[y].equals("/")==false && stack_2[y].equals("x")==false && stack_2[y+1].equals(")")==false && stack_2[y-1].equals("(") ==false){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                
                                stack_2[y+1]=")";
                                i=i+1;
                                
                                break;
                            }
                            if(cnt_1==cnt_2 && cnt_1!=0){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[y+1]=")";
                                i=i+1;
                                break;
                            }
                        }
                        }
                        else{
                        for(int j=30; j>=0; j--){
                            stack_2[j+1]=stack_2[j];
                        }
                        for(int k=30; k>=4; k--){
                            stack_2[k+1]=stack_2[k];
                        }
                        stack_2[0]="(";
                        stack_2[4]=")";
                        i=i+3;
                    }
                    }
                    else{
                        for(int y=i; y>=0; y--){   
                            if(stack_2[y].equals(")")){
                                cnt_1=cnt_1+1;
                            }
                            else if(stack_2[y].equals("(")){
                                cnt_2=cnt_2+1;
                            }
                         
                            if(cnt_1==cnt_2 && cnt_1!=0 && cnt_2!=0){
                                for(int q=30; q>=y; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[y]="(";
                                i=i+1;
                                break;
                            }
                        }
                        i=i+1; 
                        cnt_1=0;
                        cnt_2=0;
                        for(int y=i; y<30; y++){    
                            if(stack_2[y].equals("(")){
                                cnt_1=cnt_1+1;
                            }
                            else if(stack_2[y].equals(")")){
                                cnt_2=cnt_2+1;
                            }
                             else if(stack_2[y].equals("*")==false && stack_2[y].equals("/")==false && stack_2[y].equals("x")==false && stack_2[y+1].equals(")")==false && stack_2[y-1].equals("(") ==false){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                              
                                stack_2[y+1]=")";
                                i=i+1;
                                
                                break;
                            }
                            if(cnt_1==cnt_2 && cnt_1!=0){
                                for(int q=30; q>=y+1; q--){
                                    stack_2[q+1]=stack_2[q];
                                }
                                stack_2[y+1]=")";
                                i=i+1;
                                break;
                            }
                        }
                        
                    }
                }
            }

            System.out.print("=>");

            for(int k=0; k<stack_2.length; k++){
                if(stack_2[k].equals("x")==false)
                    System.out.print(stack_2[k]);
                else
                    break;
            }

                
        System.out.print("\n후위 표기법으로 변환합니다.");
                
            for(int i=0; i<30; i++){
                if(stack_2[i].equals("(")){
                    continue;
                }
                 if(stack_2[i].equals("(")==false && stack_2[i].equals(")")==false && stack_2[i].equals("+")==false &&
                        stack_2[i].equals("-")==false && stack_2[i].equals("*")==false && stack_2[i].equals("/")==false && stack_2[i].equals("x")==false){
                            for(int j=0; j<30; j++){
                                if(stack_3[j].equals("x")){
                                    stack_3[j]=stack_2[i];
                                    break;
                                }
                            }
                            continue;
                        }
                if(stack_2[i].equals("+") || stack_2[i].equals("-") || stack_2[i].equals("*") || stack_2[i].equals("/")){
                    for(int j=0; j<30; j++){
                        if(stack_3[j].equals("x")){
                            stack_oper[j]=stack_2[i];
                            break;
                        }
                    }
                    continue;
                }
                if(stack_2[i].equals(")")){
                    for(int j=0; j<30; j++){
                        if(stack_3[j].equals("x")){
                            for(int k=29; k>=0; k--){
                                if(stack_oper[k].equals("x")==false){
                                    stack_3[j]=stack_oper[k];
                                    stack_oper[k]="x";
                                    break;
                                }
                            }
                            break;
                        }
                        
                    }
                    continue;
                }
                
            }
        
             System.out.print("\n=>");
             
            for(int y=0; y<30; y++){
                if(stack_3[y].equals("x")==false){
                    System.out.print(stack_3[y]);
                }
            }

            System.out.print("\n수식을 계산합니다.\n=>");
            
           
             for(int i=0; i<30; i++){
                
                if(stack_3[i].equals("+")==false && stack_3[i].equals("-")==false && stack_3[i].equals("*")==false && 
                stack_3[i].equals("/")==false && stack_3[i].equals("x")==false){
                    for(int j=0; j<30; j++){
                        if(stack_4[j].equals("x")){
                            stack_4[j]=stack_3[i];
                            
                            break;
                        }
                    }
                    continue;
                }
                 if(stack_3[i].equals("+")){
                    for(int j=29; j>=0; j--){
                        if(stack_4[j].equals("x")==false){
                            
                            num_1=Integer.parseInt(stack_4[j]);
                            num_2=Integer.parseInt(stack_4[j-1]);
                            num_3=num_2+num_1;
                            
                            result=Integer.toString(num_3);
                            
                            stack_5[0]=result;         //입력받은 문자열을 한글자씩 분리하여 배열에 저장
                                stack_4[j]="x";
                                stack_4[j-1]=stack_5[0];
                            break;
                            
                            
                        }
                   
                    }
                    continue;
                }
                 if(stack_3[i].equals("-")){
                    for(int j=29; j>=0; j--){
                        
                        if(stack_4[j].equals("x")==false){
                            
                            num_1=Integer.parseInt(stack_4[j]);
                            num_2=Integer.parseInt(stack_4[j-1]);
                            num_3=num_2-num_1;
                            
                            result=Integer.toString(num_3);
                            
                            stack_5[0]=result;          //입력받은 문자열을 한글자씩 분리하여 배열에 저장
                                stack_4[j]="x";
                                stack_4[j-1]=stack_5[0];
                            break;
                            
                            
                        }
                   
                    }
                    continue;
                }
                if(stack_3[i].equals("*")){
                    for(int j=30; j>=0; j--){
                        if(stack_4[j].equals("x")==false){
                            
                            num_1=Integer.parseInt(stack_4[j]);
                            num_2=Integer.parseInt(stack_4[j-1]);
                            num_3=num_2*num_1;
                            
                            result=Integer.toString(num_3);
                            
                            stack_5[0]=result;           //입력받은 문자열을 한글자씩 분리하여 배열에 저장
                                stack_4[j]="x";
                                stack_4[j-1]=stack_5[0];
                            break;
                            
                            
                        }
                   
                    }
                    continue;
                }
                if(stack_3[i].equals("/")){
                    for(int j=30; j>=0; j--){
                        if(stack_4[j].equals("x")==false){
                            
                            num_1=Integer.parseInt(stack_4[j]);
                            num_2=Integer.parseInt(stack_4[j-1]);
                            num_3=num_2/num_1;
                            
                            result=Integer.toString(num_3);
                            
                            stack_5[0]=result;         //입력받은 문자열을 한글자씩 분리하여 배열에 저장
                                stack_4[j]="x";
                                stack_4[j-1]=stack_5[0];
                            break;
                            
                            
                        }
                    
                    }
                    continue;
                }

            }
            
            for(int i=0; i<30; i++){
                if(stack_4[i].equals("x")==false){
                    System.out.print(stack_4[i]);
                }
                else
                    break;
            }
           
        
            
        }
        }
    
}