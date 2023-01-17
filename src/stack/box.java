package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class box {
    public static void main(String[] args) {
        Integer[] data = new Integer[] {5};

        System.out.println("결과" + box(data));
    }

    private static int box(Integer[] boxes) {
        if(boxes.length == 1) return 1;
        //들어온 순서대로 한 명씩 나간다
        //뒷사람이 포장을 전부 끝내도 앞사람이 완료 될때까지 못나감
        //최대 몇명?

        //필요한 속성
        //기준이 되는 사람
        int head = 0;
        //나가는 사람 수
        int cnt;
        //비교되는 대상
        int max = 0;

        int tail = 0;

        int result = 0;


        //기능
        //비교하는 기능
        //카운트하는 기능
        //카운트를 저장하는 기능
        //저장된 카운트 중 최대값 찾는 기능

        //수도코드
        //기준점을 잡는다
        //링크드리스트 쓰는 이유 : 순서가 있기 때문이고 링크드 리스트 각 요소에 next(다음 요소),prev(이전 요소)가 있다.
        //어레이 리스트 안스는 이유 : 앞에가 삭제 되면 뒤에 순서를 다 땡겨야 되기 때문에 속도가 느려진다. 하지만 뒤쪽은 추가만 하면 되기에
        // 오히려 쉽다

        Queue<Integer> qBox = new LinkedList<>(Arrays.asList(boxes));
        head = qBox.poll();
        cnt = 1; //자시 자신을 카운트 하기위해

        //기준점 보다 큰값이 나올때 까지 탐색한다
        for(int i = 0; qBox.size() != 0; i++) {
            //탐색 하면서 카운트를 한다
            System.out.print(tail+" ");
            System.out.printf("%d회 \t\t ",cnt);
            System.out.printf("최댓값 %d \t\t", max);
            System.out.print("res"+result);
            tail = qBox.poll();
            if(head < tail) {
                head = tail;
                max = cnt;
                cnt = 0;
                System.out.printf("-> head : %d\t\t , max : %d\t\t",head,max);
            }
            cnt++;

            result = Math.max(max, cnt);
            System.out.printf("-> result : %d\n",result);

            //카운트를 저장을 한다
            //기준점을 옮긴다
            //위 반복
            //저장된 카운트를 비교한다
            //가장 큰 값을 리턴한다
        }
        return result;
    }
}