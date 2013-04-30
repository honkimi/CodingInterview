package code.chap3;

/**
 * �X�^�b�N��̃f�[�^�����������ɕ��בւ���v���O�����������Ă������� �i�����Ƃ��������A�C�e�����g�b�v�ɗ���)�B�f�[�^�ێ��ׂ̈ɒǉ���
 * �X�^�b�N��p���Ă��\���܂��񂪁A�X�^�b�N�ȊO�̃f�[�^�\���i�z��Ȃǁj �ɃX�^�b�N��̃f�[�^���R�s�[���Ă͍s���܂���B
 *
 * �܂��A�X�^�b�N�͈ȉ��̑���̂ݎg�p�ł��܂��B pop, push, peek, isEmpty
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
     * �X�^�b�N���̍ő�l���擾
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
     * �X�^�b�N���̎w�肵���l�ȊO�̃f�[�^��ԋp
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
     * �𓚁B���������ꂾ���A������2�̃X�^�b�N�Ŏ���
     * ���X�^�b�N��pop�f�[�^���ꎞ�I�Ƀ������ɕۑ����A
     * �\�[�g�p�X�^�b�N��pop���Ă����čœK�ȏꏊ�ɂ��̌��X�^�b�N
     * ��pop�f�[�^������B��������X�^�b�N����ɂȂ�܂ő�����
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
