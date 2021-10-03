package list;
public class Test {
    public static void main(String[] args) throws IncorrectPositionException {
        List L = new List();
        L.insert(new Data("Eva", "Toronto"), L.first());
        L.insert(new Data("Paolina", "Moscow"), L.first());
        L.insert(new Data("Maria", "Warsaw"), L.first());
        L.insert(new Data("Katya", "Helsinki"), L.first());
        L.insert(new Data("Dasha", "London"), L.first());
        L.insert(new Data("Liza", "Tokyo"), L.first());
        L.insert(new Data("Antonina", "Rome"), L.first());
        L.insert(new Data("Paolina", "Moscow"), L.first());
        L.insert(new Data("Antonina", "Rome"), L.first());
        L.insert(new Data("Eva", "Toronto"), L.first());
        L.insert(new Data("Antonina", "Rome"), L.first());
        L.insert(new Data("Katya", "Helsinki"), L.first());
        L.insert(new Data("Eva", "Toronto"), L.first());
        L.insert(new Data("Paolina", "Moscow"),L.first());
        L.insert(new Data("Eva", "Toronto"), L.first());
        System.out.println();
        L.printList();
        System.out.println();

        Position p,q;
        p = L.first();
        while (p.getP().getX() != L.end()){
            q = L.next(p);
            while (q.getP().getX() != L.end()){
                if (L.retrieve(p).getData().equals(L.retrieve(q).getData()))
                    L.delete(q);
                else
                    q = L.next(q);
            }
            p = L.next(p);
        }
        L.printList();
    }

}
