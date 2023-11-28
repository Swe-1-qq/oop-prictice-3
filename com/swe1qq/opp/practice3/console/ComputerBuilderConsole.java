package com.swe1qq.opp.practice3.console;

import com.swe1qq.opp.practice3.domain.Assembly;
import com.swe1qq.opp.practice3.domain.AssemblyImpl;
import com.swe1qq.opp.practice3.domain.ComputerAssemblyService;
import com.swe1qq.opp.practice3.persistence.entity.builders.AudioCardBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.CoolingDeviceBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.MemoryBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.MotherboardBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.ProcessorBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.RamBuilder;
import com.swe1qq.opp.practice3.persistence.entity.builders.VideoCardBuilder;
import com.swe1qq.opp.practice3.persistence.entity.enums.Brand;
import com.swe1qq.opp.practice3.persistence.entity.enums.FormFactor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerBuilderConsole {

    private final ComputerAssemblyService assemblyService;

    public ComputerBuilderConsole(Assembly assembly) {
        this.assemblyService = new ComputerAssemblyService(assembly);
    }

    public static void main(String[] args) {
        Assembly assembly = new AssemblyImpl();
        ComputerBuilderConsole builderConsole = new ComputerBuilderConsole(assembly);
        builderConsole.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nОберіть опцію:");
            System.out.println("1. Додати процесор");
            System.out.println("2. Додати пам'ять");
            System.out.println("3. Додати оперативну пам'ять");
            System.out.println("4. Додати відеокарту");
            System.out.println("5. Додати аудіокарту");
            System.out.println("6. Додати систему охолодження");
            System.out.println("7. Додати материнську плату");
            System.out.println("8. Переглянути збірку");
            System.out.println("9. Завершити");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProcessor();
                case 2 -> addMemory();
                case 3 -> addRam();
                case 4 -> addVideoCard();
                case 5 -> addAudioCard();
                case 6 -> addCoolingDevice();
                case 7 -> addMotherboard();
                case 8 -> viewAssembly();
                case 9 -> exit = true;
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void addProcessor() {
        String name = null;
        Brand brand = null;
        String socket = null;
        double price = 0.0;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введіть назву процесора:");
            name = new Scanner(System.in).nextLine();

            System.out.println("Введіть бренд процесора (1 - AMD, 2 - Intel):");
            int brandChoice = new Scanner(System.in).nextInt();

            if (brandChoice == 1) {
                brand = Brand.AMD;
                validInput = true;
            } else if (brandChoice == 2) {
                brand = Brand.INTEL;
                validInput = true;
            } else {
                System.out.println("Невірний вибір бренду процесора. Будь ласка, введіть '1' для AMD або '2' для Intel.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть сокет процесора:");
            socket = new Scanner(System.in).nextLine();

            if (!socket.isEmpty()) {
                validInput = true;
            } else {
                System.out.println("Невірно набраний сокет процесора. Будь ласка, введіть правильний сокет.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть ціну процесора:");

            try {
                price = new Scanner(System.in).nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набрана ціна процесора. Будь ласка, введіть правильне число.");
            }
        }

        ProcessorBuilder processorBuilder = new ProcessorBuilder()
                .setName(name)
                .setBrand(brand)
                .setSocket(socket)
                .setPrice(price);

        assemblyService.addProcessor(processorBuilder);
    }


    private void addMemory() {
        String name = null;
        Brand brand = null;
        String type = null;
        int capacityGB = 0;
        double price = 0.0;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введіть назву пам'яті:");
            name = new Scanner(System.in).nextLine();

            System.out.println("Виберіть бренд пам'яті (натисніть 1 для Samsung, 2 для Kingston):");
            int brandChoice = new Scanner(System.in).nextInt();

            if (brandChoice == 1) {
                brand = Brand.SAMSUNG;
                validInput = true;
            } else if (brandChoice == 2) {
                brand = Brand.KINGSTON;
                validInput = true;
            } else {
                System.out.println("Невірний вибір бренду пам'яті. Будь ласка, натисніть '1' для Samsung або '2' для Kingston.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Виберіть тип пам'яті (натисніть 1 для SSD, 2 для HDD):");
            int typeChoice = new Scanner(System.in).nextInt();

            if (typeChoice == 1) {
                type = "SSD";
                validInput = true;
            } else if (typeChoice == 2) {
                type = "HDD";
                validInput = true;
            } else {
                System.out.println("Невірний вибір типу пам'яті. Будь ласка, натисніть '1' для SSD або '2' для HDD.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть обсяг пам'яті в гігабайтах:");

            try {
                capacityGB = new Scanner(System.in).nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набраний обсяг пам'яті. Будь ласка, введіть ціле число.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть ціну пам'яті:");

            try {
                price = new Scanner(System.in).nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набрана ціна пам'яті. Будь ласка, введіть правильне число.");
            }
        }

        MemoryBuilder memoryBuilder = new MemoryBuilder()
                .setName(name)
                .setBrand(brand)
                .setType(type)
                .setCapacityGB(capacityGB)
                .setPrice(price);

        assemblyService.addMemory(memoryBuilder);
    }

    private void addMotherboard() {
        String name = null;
        Brand brand = null;
        FormFactor formFactor = null;
        boolean overclocking = false;
        double price = 0.0;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введіть назву материнської плати (наприклад B550M AORUS ELITE):");
            name = new Scanner(System.in).nextLine();

            System.out.println("Введіть бренд материнської плати (наприклад Gigabyte, Asus):");
            String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

            try {
                brand = Brand.valueOf(brandStr);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Невірно набрано бренд материнської плати. Будь ласка, використовуйте правильну назву бренду.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть форм-фактор материнської плати (наприклад ATX, MICRO_ATX):");
            String formFactorStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

            try {
                formFactor = FormFactor.valueOf(formFactorStr);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Невірно набрано форм-фактор материнської плати. Будь ласка, використовуйте правильний форм-фактор.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Підтримка оверклокінгу? (true або false):");

            try {
                overclocking = new Scanner(System.in).nextBoolean();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набране значення. Будь ласка, введіть 'true' або 'false'.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть ціну материнської плати:");

            try {
                price = new Scanner(System.in).nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набрана ціна материнської плати. Будь ласка, введіть правильне число.");
            }
        }

        MotherboardBuilder motherboardBuilder = new MotherboardBuilder()
                .setName(name)
                .setBrand(brand)
                .setPrice(price)
                .setFormFactor(formFactor)
                .setOverclocking(overclocking);

        assemblyService.addMotherboard(motherboardBuilder);
    }

    private void addRam() {
        String name = null;
        Brand brand = null;
        int capacityGB = 0;
        String type = null;
        double price = 0.0;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введіть назву RAM модуля:");
            name = new Scanner(System.in).nextLine();

            System.out.println("Введіть бренд RAM модуля (наприклад Corsair, Kingston):");
            String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

            try {
                brand = Brand.valueOf(brandStr);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Невірно набрано бренд RAM модуля. Будь ласка, використовуйте правильну назву бренду.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть обсяг RAM модуля в гігабайтах:");

            try {
                capacityGB = new Scanner(System.in).nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набраний обсяг RAM модуля. Будь ласка, введіть ціле число.");
            }
        }

        System.out.println("Введіть тип RAM модуля (наприклад DDR4, DDR5):");
        type = new Scanner(System.in).nextLine();

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть ціну RAM модуля:");

            try {
                price = new Scanner(System.in).nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набрана ціна RAM модуля. Будь ласка, введіть правильне число.");
            }
        }

        RamBuilder ramBuilder = new RamBuilder()
                .setName(name)
                .setBrand(brand)
                .setCapacityGB(capacityGB)
                .setType(type)
                .setPrice(price);

        assemblyService.addRam(ramBuilder);
    }

    private void addVideoCard() {
        String name = null;
        Brand brand = null;
        double price = 0.0;

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Введіть назву відеокарти:");
            name = new Scanner(System.in).nextLine();

            System.out.println("Введіть бренд відеокарти (наприклад Gigabyte, MSI):");
            String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

            try {
                brand = Brand.valueOf(brandStr);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Невірно набрано бренд відеокарти. Будь ласка, використовуйте правильну назву бренду.");
            }
        }

        validInput = false;

        while (!validInput) {
            System.out.println("Введіть ціну відеокарти:");

            try {
                price = new Scanner(System.in).nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Невірно набрана ціна відеокарти. Будь ласка, введіть правильне число.");
            }
        }

        VideoCardBuilder videoCardBuilder = new VideoCardBuilder()
                .setName(name)
                .setPrice(price)
                .setBrand(brand);

        assemblyService.addVideoCard(videoCardBuilder);
    }

    private void addAudioCard() {
        boolean addAudioCard = false;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Бажаєте додати аудіокарту? (true або false):");
            String addVideoCardStr = new Scanner(System.in).nextLine().toLowerCase();

            if (addVideoCardStr.equals("true") || addVideoCardStr.equals("false")) {
                addAudioCard = Boolean.parseBoolean(addVideoCardStr);
                validInput = true;
            } else {
                System.out.println("Невірно набрано значення. Будь ласка, введіть 'true' або 'false'.");
            }
        }

        if (addAudioCard) {
            String name = null;
            Brand brand = null;
            double price = 0.0;

            validInput = false;

            while (!validInput) {
                System.out.println("Введіть назву аудіокарти:");
                name = new Scanner(System.in).nextLine();

                System.out.println("Введіть бренд аудіокарти (наприкалд Realtek, Creative):");
                String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

                try {
                    brand = Brand.valueOf(brandStr);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Невірно набрано бренд аудіокарти. Будь ласка, використовуйте правильну назву бренду.");
                }
            }

            validInput = false;

            while (!validInput) {
                System.out.println("Введіть ціну аудіокарти:");

                try {
                    price = new Scanner(System.in).nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Невірно набрана ціна аудіокарти. Будь ласка, введіть правильне число.");
                }
            }

            AudioCardBuilder audioCardBuilder = new AudioCardBuilder()
                    .setName(name)
                    .setPrice(price)
                    .setBrand(brand);

            assemblyService.addAudioCard(audioCardBuilder);
        }
    }

    private void addCoolingDevice() {
        System.out.println("Бажаєте додати систему охолодження? (true або false):");
        boolean addCoolingDevice = new Scanner(System.in).nextBoolean();

        if (addCoolingDevice) {
            String name = null;
            Brand brand = null;
            boolean liquidCooling = false;
            double price = 0.0;

            boolean validInput = false;

            while (!validInput) {
                System.out.println("Введіть назву системи охолодження:");
                name = new Scanner(System.in).nextLine();

                System.out.println("Введіть бренд системи охолодження (наприклад Realtek, Creative):");
                String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");

                try {
                    brand = Brand.valueOf(brandStr);
                    validInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Невірно набрано бренд системи охолодження. Будь ласка, використовуйте правильну назву бренду.");
                }
            }

            validInput = false;

            while (!validInput) {
                System.out.println("Система охолодження рідкісна? (true або false):");

                try {
                    liquidCooling = new Scanner(System.in).nextBoolean();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Невірно набрано значення. Будь ласка, введіть 'true' або 'false'.");
                }
            }

            validInput = false;

            while (!validInput) {
                System.out.println("Введіть ціну системи охолодження:");

                try {
                    price = new Scanner(System.in).nextDouble();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Невірно набрана ціна системи охолодження. Будь ласка, введіть правильне число.");
                }
            }

            CoolingDeviceBuilder coolingDeviceBuilder = new CoolingDeviceBuilder()
                    .setName(name)
                    .setPrice(price)
                    .setBrand(brand)
                    .setLiquidCooling(liquidCooling);

            assemblyService.addCoolingDevice(coolingDeviceBuilder);
        }
    }

    private void viewAssembly() {
        String description = assemblyService.getComputerAssembly().getDescription();
        double totalPrice = assemblyService.getComputerAssembly().calculateTotalPrice();

        System.out.println(description);
        System.out.println("\nЗагальна ціна збірки: \n" + totalPrice + " грн");
    }
}
