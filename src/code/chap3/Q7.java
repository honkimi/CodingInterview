package code.chap3;

import java.util.LinkedList;

/**
 * イヌとネコしか入ることのできない動物保護施設があります。
 * この施設は「先出先出」の操作を厳格に行います。施設からは
 * 一番長い時間入っている動物を外に出すか、イヌとネコのすきなほう
 * （で一番長い時間入っているもの）を外に出すことができます。
 * どの動物でも好きなように連れ出せるわけではありません。このような
 * 仕組みを扱うデータ構造を作ってください。さらにenqueue, dequeueAny,
 * dequeueDog, dequeueCatの操作を実装してください。
 * あらかじめ用意された連結リストのデータ構造は用いてよいものとします。
 * @author kimi
 *
 * ↓の方法だと、dequeueAnyは高速だが、dequeueDog, dequeueCatが
 * 色々と計算が必要になり、効率が悪い。
 * Dog用のQueueとCat用のQueueに分けて、それぞれにorderを保存し、
 * dequeueする際にそのOrderが古い方を返却するようにするといい感じになる。
 */
public class Q7 {
    public interface Animal {
        public void bark();
    }

    public class Dog implements Animal {
        public void bark() {
            System.out.println("わん！");
        }
    }
    public class Cat implements Animal {
        public void bark() {
            System.out.println("にゃー！");
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
