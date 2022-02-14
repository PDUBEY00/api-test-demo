Feature:Get the quote as  per Market conversion Rate


  Scenario: Create quote for payment conversion
    Given user is authenticated to access payment engine
    And User is happy with market rate to "sell" 1000.00 "GBP" to buy "USD"
    When user request a conversion quote to "sell" 1000.00 "GBP" to buy "USD"
    Then user should be able to create quote without any issue
    And buy amount should be as per the market rate

  Scenario Outline: Throws valid Error when invalid data supplied
    Given user is authenticated to access payment engine
    When user requests a conversion quote with invalid "<value>" for "<parameter>"
    Then user should see error status <code> and "<error message>" for supplied "<parameter>"


    Examples:
      | parameter     | value  | code | error message                                       |
      | fixed_side    | Buying | 400  | fixed_side should be in range: buy, sell            |
      | sell_currency | BUGG   | 400  | sell_currency is not a valid ISO 4217 currency code |
      | buy_currency  | USDD   | 400  | buy_currency is not a valid ISO 4217 currency code  |







