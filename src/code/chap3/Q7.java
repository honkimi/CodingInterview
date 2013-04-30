package code.chap3;

import java.util.LinkedList;

/**
 * �C�k�ƃl�R�������邱�Ƃ̂ł��Ȃ������ی�{�݂�����܂��B
 * ���̎{�݂́u��o��o�v�̑�������i�ɍs���܂��B�{�݂����
 * ��Ԓ������ԓ����Ă��铮�����O�ɏo�����A�C�k�ƃl�R�̂����Ȃق�
 * �i�ň�Ԓ������ԓ����Ă�����́j���O�ɏo�����Ƃ��ł��܂��B
 * �ǂ̓����ł��D���Ȃ悤�ɘA��o����킯�ł͂���܂���B���̂悤��
 * �d�g�݂������f�[�^�\��������Ă��������B�����enqueue, dequeueAny,
 * dequeueDog, dequeueCat�̑�����������Ă��������B
 * ���炩���ߗp�ӂ��ꂽ�A�����X�g�̃f�[�^�\���͗p���Ă悢���̂Ƃ��܂��B
 * @author kimi
 *
 * ���̕��@���ƁAdequeueAny�͍��������AdequeueDog, dequeueCat��
 * �F�X�ƌv�Z���K�v�ɂȂ�A�����������B
 * Dog�p��Queue��Cat�p��Queue�ɕ����āA���ꂼ���order��ۑ����A
 * dequeue����ۂɂ���Order���Â�����ԋp����悤�ɂ���Ƃ��������ɂȂ�B
 */
public class Q7 {
    public interface Animal {
        public void bark();
    }

    public class Dog implements Animal {
        public void bark() {
            System.out.println("���I");
        }
    }
    public class Cat implements Animal {
        public void bark() {
            System.out.println("�ɂ�[�I");
        }
    }

    public class Facility {
        private LinkedList<Animal> animals;

        public Facility() {
            animals = new LinkedList<Animal>();
        }

        public void add(Animal animal) {
            animals.add(animal);
        }

        public void enqueue(Animal animal) {
            animals.addFirst(animal);
        }

        public Animal dequeueAny() {
            Animal animal = animals.removeLast();
            animal.bark();
            return animal;
        }

        public Animal dequeueDog() {
            return dequeueBy(Dog.class);
        }

        public Animal dequeueCat() {
            return dequeueBy(Cat.class);
        }

        private Animal dequeueBy(Class<?> clazz) {
            Animal animal;
            LinkedList<Animal> buffer = new LinkedList<Animal>();
            animal = animals.removeLast();

            while (!animal.getClass().equals(clazz)) {
                buffer.add(animal);
                animal = animals.removeLast();
            }
            animal.bark();

            while (!buffer.isEmpty()) {
                animals.add(buffer.removeFirst());
            }

            return animal;
        }
    }

}
