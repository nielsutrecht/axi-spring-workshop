package be.axi.myapp.myapp.example;

public class IoC {
    static class Register {
        private int money = 0;

        public void addMoney(int amount) {
            money += amount;
        }

        public int takeMoney(int amount) {
            money -= amount;

            return money;
        }
    }






static class PetShop {
    private Register register = new Register();
}









static class IoCPetShop {
    private Register register;

    public IoCPetShop(Register register) {
        this.register = register;
    }
}






    public static void main(String... arv) {
        //No IoC / DI
        PetShop petShop = new PetShop();

        //IoC / DI
        Register register = new Register();
        IoCPetShop ioCPetShop = new IoCPetShop(register);
    }
}
