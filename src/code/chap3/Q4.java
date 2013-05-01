package code.chap3;

/**
 * �ÓT�I�ȃn�m�C�̓��̖��ł́A3�̓���N���̃T�C�Y�̈قȂ� �~�Ղ�p���ē��̊Ԃ��ړ������܂��B�ŏ��͉~�Ղ���������
 * �������ď������Ȃ�悤�Ɂi�ǂ̉~�Ղ����g���傫�ȉ~�Ղ̏�ɍڂ��Ă���悤�Ɂj �Ȃ��Ă��܂��B�����ĉ��̂悤�Ȑ���������܂��B
 * �P�A��x��1���̉~�Ղ����������Ȃ��B �Q�A���̈�ԏ�ɂ���~�Ղ𑼂̓��Ɉړ�������B �R�A�~�Ղ�u���Ƃ��́A���ꎩ�g���傫�Ȃ��̂̏�ɂ����u���Ȃ��B
 * �X�^�b�N��p���āA�ŏ��̓��ɐς݂������Ă���~�Ղ��Ō�̓��� �ړ�������v���O�����������Ă��������B
 *
 * @author kiminari.homma
 *
 */
public class Q4 {

    public class Tower {

        public java.util.Stack<Integer> disks;
        private int index;
        public Tower(int i) {
            disks = new java.util.Stack<Integer>();
            index = i;
        }

        public int index() {
            return index;
        }

        public void add(int d) {
            if(!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk" + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

}

/*
 * �ċA���l����Ƃ��̃���
 *
 * �E�܂��n�߂ɁAn=1����͂��߁A1�����₵�Ă݂�B
 * [�d�v]n��1������Ƃ��ɁA�O�̌��ʂ����p�ł��Ȃ������l����I
 *
 * �������p�ł������ȏꍇ�́A����͍ċA���g����\���������B
 *
 *
 * ����̃n�m�C�̓��̖��̏ꍇ:
 *
 * n=0 �̂Ƃ��͉������Ȃ��B
 *
 * n=1 �̂Ƃ��͓�1���瓃3�ւɈڂ�����.      moveTopTo(destination);
 *
 * n=2 �̂Ƃ���
 *      �~��1��1���瓃2�ւ����Ă����A     moveDisks(n - 1, buffer, destination);
 *      �~��2��1���瓃3�ւ����Ă����A     moveTopTo(destination);
 *      �~��1��2���瓃3��                 buffer.moveDisks(n - 1, destination, this);
 *
 * n=3 �̂Ƃ���
 *      n=2�̂Ƃ��̂悤�ɂ��ď�2�̉~�Ղ�2�֎����Ă����A      moveDisks(n - 1, buffer, destination);
 *      �~��3��1���瓃3�ֈڂ������Ƃ�                          moveTopTo(destination);
 *      n=2�̂Ƃ��̂悤�ɂ��ē�2�ɂ���~�Ղ�����3�ւ����Ă���  buffer.moveDisks(n - 1, destination, this);
 *
 * n=4 �̂Ƃ���
 *      n=3�̂Ƃ��̂悤�ɂ��ď�3�̉~�Ղ�2�֎����Ă����A      moveDisks(n - 1, buffer, destination);
 *      �~��4��1���瓃3�ֈڂ������Ƃ�                          moveTopTo(destination);
 *      n=3�̂Ƃ��̂悤�ɂ��ē�2�ɂ���~�Ղ�����3�ւ����Ă���  buffer.moveDisks(n - 1, destination, this);
 * ...
 *
 * �ĂȊ����ɂȂ�B
 *
 */
