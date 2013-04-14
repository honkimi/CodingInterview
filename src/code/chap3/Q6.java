package code.chap3;

/**
 * スタック上のデータを小さい順に並べ替えるプログラムを書いてください （もっとも小さいアイテムがトップに来る)。データ保持の為に追加の
 * スタックを用いても構いませんが、スタック以外のデータ構造（配列など） にスタック上のデータをコピーしては行けません。
 *
 * また、スタックは以下の操作のみ使用できます。 pop, push, peek, isEmpty
 *
 * @author kimi
 *
 */
public class Q6 {
    static class DtoForSort {
        Stack stack;
        int max;

        public DtoForSort(Stack stack, int max) {
            this.stack = stack;
            this.max = max;
        }
    }

    public static Stack sortStack(Stack stack) {
        Stack result = new Stack();
        DtoForSort dto = new DtoForSort(stack, 0);

        while (!stack.isEmpty()) {
            dto = findMaxInStack(stack);
            result.push(dto.max);

            stack = popMaxInStack(dto.stack, dto.max);
        }
        return result;
    }

    /**
     * スタック内の最大値を取得
     *
     * @param stack
     * @return
     */
    private static DtoForSort findMaxInStack(Stack stack) {
        DtoForSort dto = new DtoForSort(stack, 0);
        Stack buff = new Stack();
        if (stack.isEmpty()) {
            return null;
        }
        Integer data = (Integer) stack.pop();
        int max = data;
        while (data != null) {
            if (max < data) {
                max = data;
            }
            buff.push(data);
            data = (Integer) stack.pop();
        }
        dto.stack = buff;
        dto.max = max;

        return dto;
    }

    /**
     * スタック内の指定した値以外のデータを返却
     *
     * @param stack
     * @param max
     * @return
     */
    private static Stack popMaxInStack(Stack stack, int max) {
        Stack result = new Stack();
        if (stack.isEmpty()) {
            System.out.println("stack is null!");
            return result;
        }

        Integer data = (Integer) stack.pop();
        while (data != null) {
            if (data != max) {
                result.push(data);
            }
            data = (Integer) stack.pop();
        }
        return result;
    }

    /**
     * 解答。たったこれだけ、しかも2つのスタックで実装
     * 元スタックのpopデータを一時的にメモリに保存し、
     * ソート用スタックをpopしていって最適な場所にその元スタック
     * のpopデータを入れる。それを元スタックが空になるまで続ける
     * @param s
     * @return
     */
    public static Stack sort(Stack s) {
        Stack r = new Stack();
        while (!s.isEmpty()) {
            int tmp = (int) s.pop();
            while (!r.isEmpty() && (int) r.peek() < tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

}
