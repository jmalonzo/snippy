# Random snippets of Foo #

`snippy` is just my dump of random functions that I use for different
kinds of stuff.

# Using #

Usage is via the REPL. This will change eventually once I have
more stuff here.

# Example #

    ; Calculate the purchase tax of 30 shares at the fair market value 
    ; of $50.00 per share.
    (calc-espp-purchase-tax 50.00 30)

    ; Calculate the sales tax of 100 shares at the selling price of
    ; $50.00. Purchase price was $25.00.
    (calc-espp-sales-tax 50.00 25.00 1000)
