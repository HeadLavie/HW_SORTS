package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

   Ticket ticket = new Ticket("Dublin", "Moscow", 100, 15,18);
   Ticket ticket2 = new Ticket("Dublin", "Moscow", 200, 16,22);
   Ticket ticket3 = new Ticket("Dublin", "London", 200, 21,24);
   Ticket ticket4 = new Ticket("Dublin", "Moscow", 50, 1,12);
   Ticket ticket5 = new Ticket("Dublin", "Moscow", 40, 10,17);

    @Test
    public void ShouldTestCompareTo() {

        int expected = -1;
        int actual = ticket.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void ShouldTestCompareToReversed() {

        int expected = 1;
        int actual = ticket2.compareTo(ticket);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldTestCompareToSamePrice() {

        int expected = 0;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldTestArraySort() {

        AviaSouls aviaSouls = new AviaSouls();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket5, ticket4, ticket, ticket2};
        Ticket[] actual = aviaSouls.search("Dublin", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestTicketTimeComparator() {

   TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = ticketTimeComparator.compare(ticket5, ticket2);

        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void ShouldTestSearchAndSortBy() {

        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket, ticket2, ticket5, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy("Dublin", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestSearchAndSortByOneTicket() {

        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Dublin", "London", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldTestSearchAndSortByZeroTickets() {

        AviaSouls aviaSouls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        aviaSouls.add(ticket);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Dublin", "Ankara", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}


