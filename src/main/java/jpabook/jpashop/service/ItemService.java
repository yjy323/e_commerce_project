package jpabook.jpashop.service;

import java.util.List;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  @Transactional
  public void saveItem(Item item) {
    itemRepository.save(item);
  }

  public Item findOne(Long itemId) {
    return itemRepository.findOne(itemId);
  }
  public List<Item> findItems() {
    return itemRepository.findAll();
  }

  @Transactional
  public void updateItem(Long id, String name, int price, int stockQuantity) {
    Item item = itemRepository.findOne(id);
    item.setName(name);
    item.setPrice(price);
    item.setStockQuantity(stockQuantity);
  }
}
