package com.thedevhorse.command;

import java.util.List;

public interface ProductCommand {

    void execute(List<Product> shoppingCart);
}
