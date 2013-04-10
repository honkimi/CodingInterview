package code.chap3;

/**
 * �M���ς݂������Ă���󋵂��C���[�W���Ă��������B�����A�����ςݏオ�肷������|��Ă��܂��ł��傤�B
 * �ł�����A�������ł̓X�^�b�N������̈�𒴂����Ƃ��A�V�����X�^�b�N��p�ӂ��邱�ƂɂȂ�ł��傤�B
 * ������܂˂��f�[�^�\��SetOfStacks���������Ă��������BSetOfStacks�͂������̃X�^�b�N�������A�X�^�b�N�̃f�[�^����t�ɂȂ�����
 * �X�^�b�N��V���ɍ��Ȃ���΂Ȃ�܂���B�܂��ASetOfStacks.push()��SetOfStacks.pop()�͕��ʂ̃X�^�b�N
 * �̂悤�ɂӂ�܂��悤�ɂ��Ă��������i�܂�Apop()�͒ʏ�̈�̃X�^�b�N�̏ꍇ�Ɠ����l��Ԃ��Ȃ���΂Ȃ�܂���j�B
 * @author kiminari.homma
 *
 */
public class Q3 {

    public class SetOfStacks {
        final static int MAX_STACK = 2;
        Node top = null;
        Stack stacks = null;
        int current_num = 0;

        public SetOfStacks() {
            stacks = new Stack();
            stacks.push(new Stack());
        }

        public Object pop() {
            if (current_num != 0) {
                current_num--;
                return ((Stack) stacks.peek()).pop();
            } else {
                //������-1�͎��Ԃ��������B�B
                current_num = MAX_STACK-1;
                stacks.pop();
                return ((Stack) stacks.peek()).pop();
            }
        }

        public void push (Object item) {
            if (MAX_STACK > current_num) {
                ((Stack)stacks.peek()).push(item);
                current_num++;
            } else {
                stacks.push(new Stack());
                ((Stack) stacks.peek()).push(item);
                current_num = 1;
            }
        }
    }
}
