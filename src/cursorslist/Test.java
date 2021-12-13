package cursorslist;

public class Test {
    public static void main(String[] args) {
        List L = new List();
        init(L);

        Position p,q;
        p = L.first();
        while (!p.equals(L.end())){
            q = L.next(p);
            while (!q.equals(L.end())) {

                if (L.retrieve(p).equals(L.retrieve(q)))
                    L.delete(q);
                else {
                    q = L.next(q);
                }
            }
            p = L.next(p);
        }
        L.printList();
    }

    public static void init(List L){
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
        L.printList();
        System.out.println();
    }
}
