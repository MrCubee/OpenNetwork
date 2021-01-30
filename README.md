# Network Protocol
This protocol allows to create a network of minecraft servers. 
It can also allow multiple networks to communicate with each other if all use the same protocol.

## Packets (There are 22 packets)

### Common packets:

---
#### Message packets
- [X] ChannelMessage
- [X] TargetedMessage
---


### Server packets:

#### Server memory status packets
- [X] ServerMemoryStatsRequest
- [X] ServerMemoryStats
---
#### Server game status packets.
- [X] ServerGameStatusRequest
- [X] ServerGameStatus
---

### Proxy packets:

---
#### Player send packets
- [ ] ProxySendPlayerRequest
- [ ] ProxySendPlayerReply
---
#### Player reserve slot packets
- [ ] ProxyPlayerReserveSlotRequest
- [ ] ProxyPlayerReserveSlotReply
---
#### Check player ban packets
- [ ] ProxyPlayerBan
- [ ] ProxyPlayerBanReply
---
#### Player role packets
- [ ] ProxyPlayerRoleRequest
- [ ] ProxyPlayerRoleReply
- [ ] ProxyPlayerRoleUpdateRequest
- [ ] ProxyPlayerRoleUpdateReply
---
#### Stats packets
- [ ] ProxyStatsRequest
- [ ] ProxyStatsReply
---

### Server On Demand packets:

---
#### Server create packets
- [ ] SODCreateRequest
- [ ] SODCreateReply
---

---
### Server delete packets
- [ ] SODRemoveRequest
- [ ] SODRemoveReply
---