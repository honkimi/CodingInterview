package code.chap3;

/**
 * MyQueue�Ƃ����N���X����2�̃X�^�b�N��p���ăL���[���������Ă��������B
 * @author kimi
 *
 * �V���v���Ƀo�b�t�@�[�p�̃X�^�b�N������āAdequeue�̎���
 * �ꎞ�I�ɃX�^�b�N�̈�ԉ��܂�buffer�Ɏ����čs���āA��ԉ��̃I�u�W�F�N�g�����o���B
 * �����A���ꂾ�Ɩ���dequeue�̓x�Ɍv�Z���Ȃ��Ƃ����Ȃ��Ȃ�B
 *
 * ����̑Ή��Ƃ���dequeue���Ă΂ꂽ�Ƃ��ɂ�����̃X�^�b�N��
 * ���݂���X�^�b�N�S�Ă�pop��push���Ă����B
 * ������̃X�^�b�N����ɂȂ�܂ł͂��̃X�^�b�N����
 * �v�f�����o�������ł悭�Ȃ�B
 * ������ɂȂ�����A�܂����݂̃X�^�b�N���������̃X�^�b�N�Ɉڂ����Ƃ�����΂悢�B
 * �v�����˂��E�E�B
 *
 */
public class Q5 {

    public class MyQueue {
        public Stack queue, buffer;

        public MyQueue() {
            queue  = new Stack();
            buffer = new Stack();
        }

        public Object dequeue() {
            Object mov = queue.pop();;
            Object ret;
            if(mov == null) {
                return null;
            }
            while (mov != null) {
                buffer.push(mov);
                mov = queue.pop();
            }
            ret = buffer.pop();

            mov = buffer.pop();
            while (mov != null ) {
                queue.push(mov);
                mov = buffer.pop();
            }
            return ret;
        }

        public void enqueue(Object obj) {
            queue.push(obj);
        }
    }
}
