import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args){

        Album album = new Album("Album1", "AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway To Hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

       album = new Album("Album2", "Eminem");

        album.addSong("Rap God",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose Yourself",5.0);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway To Hell",playList_1);
        albums.get(1).addToPlayList("Rap God",playList_1);
        albums.get(1).addToPlayList("Lose Yourself",playList_1);

        play(playList_1);

    }

    private static  void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This play list has no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action =sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;


                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }else {
                        System.out.println("no song availabel , reached to the and of the list");
                        forward = false;
                    }
                    break;


                case 2:
                    if (forward ){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());

                    }else {
                        System.out.println("We are at the first song ");
                        forward=false;
                    }
                    break;


                case 3:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward=false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                        }else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                            forward=true;
                        }else {
                            System.out.println("We have reached to the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;


                case 5:
                    printMenu();
                    break;


                case 6:
                    if(playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing "+ listIterator.next().toString());
                        }
                        else{
                            if (listIterator.hasPrevious())
                            System.out.println("Now playing "+listIterator.previous().toString());
                        }
                    }
            }
        }
    }



    private static  void printMenu(){
        System.out.println("Availabe options\n press");
        System.out.println("0- to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - to List of all Songs\n"+
                "5 - print all availabe options\n"+
                "6 - to delete current song from albums\n");
    }

    private static void printList(LinkedList<Song> playList){

        Iterator<Song> iterator = playList.iterator();
        System.out.println("-------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------");

    }
}