
// fist panel
        labels[0] = new JLabel("R: ");
        textField[0] = new JTextField();
        panels[0] = new JPanel(new BorderLayout());
        panels[0].add(labels[0], BorderLayout.WEST);
        panels[0].add(slider[0], BorderLayout.CENTER);
        panels[0].add(textField[0], BorderLayout.EAST);

        // second panel
        labels[1] = new JLabel("G: ");
        textField[1] = new JTextField();
        panels[1] = new JPanel(new BorderLayout());
        panels[1].add(labels[1], BorderLayout.WEST);
        panels[1].add(slider[1], BorderLayout.CENTER);
        panels[1].add(textField[1], BorderLayout.EAST);

        // third panel
        labels[2] = new JLabel("B: ");
        textField[2] = new JTextField();
        panels[2] = new JPanel(new BorderLayout());
        panels[2].add(labels[2], BorderLayout.WEST);
        panels[2].add(slider[2], BorderLayout.CENTER);
        panels[2].add(textField[2], BorderLayout.EAST);