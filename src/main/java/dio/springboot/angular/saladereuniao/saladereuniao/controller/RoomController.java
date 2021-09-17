package dio.springboot.angular.saladereuniao.saladereuniao.controller;

import dio.springboot.angular.saladereuniao.saladereuniao.exception.ResourceNotFoungException;
import dio.springboot.angular.saladereuniao.saladereuniao.model.Room;
import dio.springboot.angular.saladereuniao.saladereuniao.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
// @RequiredArgsConstructor
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) throws ResourceNotFoungException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoungException("Room not found::" + id));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
        return ResponseEntity.created(URI.create("/rooms/" + room.getId())).body(roomRepository.save(room));
        //return roomRepository.save(room);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room roomDetails) throws ResourceNotFoungException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoungException("Room not found:: " + id));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom = roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/rooms/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable Long id) throws ResourceNotFoungException {
        Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoungException("Room not found:: " +id));

        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
